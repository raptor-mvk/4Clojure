; Topic: sequences

(ns
  ^{:author raptor}
  seqs.task34
  (:use clojure.test))

(defn re-range
  "Reimplementation of 'range' with two parameters"
  [x y]
  (take (- y x) (iterate inc x)))

(deftest test1 (is (= (re-range 1 4) '(1 2 3))))

(deftest test2 (is (= (re-range -2 2) '(-2 -1 0 1))))

(deftest test3 (is (= (re-range 5 8) '(5 6 7))))

(run-tests 'seqs.task34)