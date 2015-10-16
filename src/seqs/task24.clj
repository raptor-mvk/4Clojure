; Topic: sequences

(ns
  ^{:author raptor}
  seqs.task24
  (:use clojure.test))

(defn sum
  "Returns sum of all elements from a sequence"
  [coll]
  (reduce + coll))

(deftest test1 (is (= (sum [1 2 3]) 6)))

(deftest test2 (is (= (sum (list 0 -2 5 5)) 8)))

(deftest test3 (is (= (sum #{4 2 1}) 7)))

(deftest test4 (is (= (sum '(0 0 -1)) -1)))

(deftest test5 (is (= (sum '(1 10 3)) 14)))

(run-tests 'seqs.task24)