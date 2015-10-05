; Topic: sequences

(ns
  ^{:author raptor}
  seqs.task22
  (:use clojure.test))

(defn re-count
  "Reimplementation of 'count'"
  [c] (reduce (fn [x y] (inc x)) 0 c))

(deftest test1 (is (= (re-count '(1 2 3 3 1)) 5)))

(deftest test2 (is (= (re-count "Hello World") 11)))

(deftest test3 (is (= (re-count [[1 2] [3 4] [5 6]]) 3)))

(deftest test4 (is (= (re-count '(13)) 1)))

(deftest test5 (is (= (re-count '(:a :b :c)) 3)))

(run-tests 'seqs.task22)