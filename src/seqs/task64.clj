; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task64
  (:use clojure.test))

(def func
  "Define function that satisfies the given test conditions"
  +)

(deftest test1 (is (= 15 (reduce func [1 2 3 4 5]))))

(deftest test2 (is (= 0 (reduce func []))))

(deftest test3 (is (= 6 (reduce func 1 [2 3]))))

(run-tests 'seqs.task64)