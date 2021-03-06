; Topic: core functions

(ns
  ^{:author "raptor_MVK"}
  core.task22
  (:use clojure.test))

(defn re-count
  "Reimplementation of 'count'"
  [coll]
  (reduce (fn [x _] (inc x)) 0 coll))

(deftest test1 (is (= (re-count '(1 2 3 3 1)) 5)))

(deftest test2 (is (= (re-count "Hello World") 11)))

(deftest test3 (is (= (re-count [[1 2] [3 4] [5 6]]) 3)))

(deftest test4 (is (= (re-count '(13)) 1)))

(deftest test5 (is (= (re-count '(:a :b :c)) 3)))

(run-tests 'core.task22)