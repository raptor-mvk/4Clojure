; Topic: language
; Subtopic: basic sequence manipulating

(ns
  ^{:author raptor}
  lang.task22
  (:use clojure.test))

(defn re-count
  "Reimplementation of 'count'"
  [z] (reduce (fn [x y] (+ x 1)) 0 z))

(deftest test1 (is (= (re-count '(1 2 3 3 1)) 5)))

(deftest test2 (is (= (re-count "Hello World") 11)))

(deftest test3 (is (= (re-count [[1 2] [3 4] [5 6]]) 3)))

(deftest test4 (is (= (re-count '(13)) 1)))

(deftest test5 (is (= (re-count '(:a :b :c)) 3)))

(run-tests 'lang.task22)