; Topic: core functions

(ns
  ^{:author "raptor_MVK"}
  core.task34
  (:use clojure.test))

(defn re-range
  "Reimplementation of 'range' with two parameters"
  [m n]
  (take (- n m) (iterate inc m)))

(deftest test1 (is (= (re-range 1 4) '(1 2 3))))

(deftest test2 (is (= (re-range -2 2) '(-2 -1 0 1))))

(deftest test3 (is (= (re-range 5 8) '(5 6 7))))

(run-tests 'core.task34)