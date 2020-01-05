; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task112
  (:use clojure.test))

(defn get-cumulative-seq
  "Given an integer and a nested collection of integers as arguments, returns a sequence which maintains the nested
  structure, and which includes all elements starting from the head whose sum is less than or equal to the input
  integer"
  [n coll]
  (if (empty? coll)
    '()
    (let [coll-head (first coll)
          coll-tail (rest coll)]
      (if (coll? coll-head)
        (concat [(get-cumulative-seq n coll-head)] (get-cumulative-seq (- n (reduce + (flatten coll-head))) coll-tail))
        (if (>= n coll-head)
          (concat [coll-head] (get-cumulative-seq (- n coll-head) coll-tail))
          '())))))

(deftest test1 (is (= (get-cumulative-seq 10 [1 2 [3 [4 5] 6] 7]) '(1 2 (3 (4))))))

(deftest test2 (is (= (get-cumulative-seq 30 [1 2 [3 [4 [5 [6 [7 8]] 9]] 10] 11]) '(1 2 (3 (4 (5 (6 (7)))))))))

(deftest test3 (is (= (get-cumulative-seq 9 (range)) '(0 1 2 3))))

(deftest test4 (is (= (get-cumulative-seq 1 [[[[[1]]]]]) '(((((1))))))))

(deftest test5 (is (= (get-cumulative-seq 0 [1 2 [3 [4 5] 6] 7]) '())))

(deftest test6 (is (= (get-cumulative-seq 0 [0 0 [0 [0]]]) '(0 0 (0 (0))))))

(deftest test7 (is (= (get-cumulative-seq 1 [-10 [1 [2 3 [4 5 [6 7 [8]]]]]]) '(-10 (1 (2 3 (4)))))))

(run-tests 'seqs.task112)