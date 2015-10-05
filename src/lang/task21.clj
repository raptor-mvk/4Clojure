; Topic: language
; Subtopic: basic sequence manipulating

(ns
  ^{:author raptor}
  lang.task21
  (:use clojure.test))

(defn re-nth
  "Reimplementation of 'nth'"
  [c n] (-> c (nthnext n) first))

(deftest test1 (is (= (re-nth '(4 5 6 7) 2) 6)))

(deftest test2 (is (= (re-nth [:a :b :c] 0) :a)))

(deftest test3 (is (= (re-nth [1 2 3 4] 1) 2)))

(deftest test4 (is (= (re-nth '([1 2] [3 4] [5 6]) 2) [5 6])))

(run-tests 'lang.task21)