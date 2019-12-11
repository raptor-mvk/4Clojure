; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task2
  (:use clojure.test))

(def result
  "Define value that satisfies the given test condition"
  4)

(deftest test1 (is (= (- 10 (* 2 3)) result)))

(run-tests 'elem.task2)