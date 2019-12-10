; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task25
  (:use clojure.test))

(defn odd-filter
  "Returns only the odd numbers from a sequence"
  [coll]
  (filter odd? coll))

(deftest test1 (is (= (odd-filter #{1 2 3 4 5}) '(1 3 5))))

(deftest test2 (is (= (odd-filter [4 2 1 6]) '(1))))

(deftest test3 (is (= (odd-filter [2 2 4 6]) '())))

(deftest test4 (is (= (odd-filter [1 1 1 3]) '(1 1 1 3))))

(run-tests 'seqs.task25)