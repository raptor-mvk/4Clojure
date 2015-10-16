; Topic: elementary

(ns
  ^{:author raptor_MVK}
  elem.task15
  (:use clojure.test))

(defn x2
  "Given x, return doubled value of x"
  [x]
  (* x 2))

(deftest test1 (is (= (x2 2) 4)))

(deftest test2 (is (= (x2 3) 6)))

(deftest test3 (is (= (x2 11) 22)))

(deftest test4 (is (= (x2 7) 14)))

(run-tests 'elem.task15)