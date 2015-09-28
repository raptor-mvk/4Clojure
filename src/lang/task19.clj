; Topic: language
; Subtopic: basic sequence manipulating

(ns
  ^{:author raptor}
  lang.task19
  (:use clojure.test))

(defn re-last
  "Reimplementation of 'last'"
  [x] (-> x reverse first))

(deftest test1 (is (= (re-last [1 2 3 4 5]) 5)))

(deftest test2 (is (= (re-last '(5 4 3)) 3)))

(deftest test3 (is (= (re-last ["b" "c" "d"]) "d")))

(run-tests 'lang.task19)
