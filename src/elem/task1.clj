; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task1
  (:use clojure.test))

(def true-value
  "Define value that satisfies the given test condition"
  true)

(deftest test1 (is (= true-value true)))

(run-tests 'elem.task1)