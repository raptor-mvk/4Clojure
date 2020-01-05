; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task114
  (:use clojure.test))

(defn take-while-nth
  "Given an integer n, a predicate p, and a sequence, returns a lazy sequence of items in the list up to, but not
  including, the nth item that satisfies the predicate."
  [n p coll]
  (loop [i n
         cur-coll coll
         res []]
    (let [head (take-while (complement p) cur-coll)
          tail (drop-while (complement p) cur-coll)]
      (if (= 1 i)
        (concat res head)
        (recur (dec i) (rest tail) (concat res head [(first tail)]))))))

(deftest test1 (is (= [2 3 5 7 11 13] (take-while-nth 4 #(= 2 (mod % 3)) [2 3 5 7 11 13 17 19 23]))))

(deftest test2 (is (= ["this" "is" "a" "sentence"]
                      (take-while-nth 3 #(some #{\i} %) ["this" "is" "a" "sentence" "i" "wrote"]))))

(deftest test3 (is (= ["this" "is"] (take-while-nth 1 #{"a"} ["this" "is" "a" "sentence" "i" "wrote"]))))

(run-tests 'seqs.task114)