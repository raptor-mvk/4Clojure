; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task12
  (:use clojure.test))

(def result
  "Define value that satisfies the given test conditions"
  3)

(deftest test1 (is (= result (first '(3 2 1)))))

(deftest test2 (is (= result (second [2 3 4]))))

(deftest test3 (is (= result (last (list 1 2 3)))))

(run-tests 'elem.task12)