; Topic: graph

(ns
  ^{:author "raptor_MVK"}
  graph.task106
  (:use clojure.test))

(defn shortest-path-length
  "Given a pair of numbers, the start and end point, returns length of the shortest path between the two using only
  three possible operations: double, halve (odd numbers cannot be halved) and add 2"
  [a b]
  (loop [queue [[a 1]]
         used #{}]
    (let [cur-queue-item (first queue)
          cur-num (first cur-queue-item)
          cur-len (last cur-queue-item)
          n (inc cur-len)]
      (if (= cur-num b)
        cur-len
        (let [good? (nil? (some #{cur-num} used))
              new-queue-items (if good? [[(* cur-num 2) n] [(+ cur-num 2) n]] [])
              new-queue-items-for-even-num (if (and (even? cur-num) good?) [[(quot cur-num 2) n]] [])]
          (recur (concat (rest queue) new-queue-items new-queue-items-for-even-num) (into used [cur-num])))))))

(deftest test1 (is (= 1 (shortest-path-length 1 1))))       ; 1

(deftest test2 (is (= 3 (shortest-path-length 3 12))))      ; 3 6 12

(deftest test3 (is (= 3 (shortest-path-length 12 3))))      ; 12 6 3

(deftest test4 (is (= 3 (shortest-path-length 5 9))))       ; 5 7 9

(deftest test5 (is (= 9 (shortest-path-length 9 2))))       ; 9 18 20 10 12 6 8 4 2

(deftest test6 (is (= 5 (shortest-path-length 9 12))))      ; 9 11 22 24 12

(run-tests 'graph.task106)