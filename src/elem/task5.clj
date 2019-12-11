; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task5
  (:use clojure.test))

(def value
  "Define value that satisfies the given test conditions"
  '(1 2 3 4))

(deftest test1 (is (= value (conj '(2 3 4) 1))))

(deftest test2 (is (= value (conj '(3 4) 2 1))))

(run-tests 'elem.task5)