; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task13
  (:use clojure.test))

(def result
  "Define value that satisfies the given test condition"
  [20 30 40])

(deftest test1 (is (= result (rest [10 20 30 40]))))

(run-tests 'elem.task13)