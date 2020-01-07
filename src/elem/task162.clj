; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task162
  (:use clojure.test))

(def value
  "Define value that satisfies the given test conditions"
 1)

(deftest test1 (is (= value (if-not false 1 0))))

(deftest test2 (is (= value (if-not nil 1 0))))

(deftest test3 (is (= value (if true 1 0))))

(deftest test4 (is (= value (if [] 1 0))))

(deftest test5 (is (= value (if [0] 1 0))))

(deftest test6 (is (= value (if 0 1 0))))

(deftest test7 (is (= value (if 1 1 0))))

(run-tests 'elem.task162)