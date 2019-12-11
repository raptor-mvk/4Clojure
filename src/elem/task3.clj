; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task3
  (:use clojure.test))

(def result
  "Define value that satisfies the given test condition"
  "HELLO WORLD")

(deftest test1 (is (= result (.toUpperCase "hello world"))))

(run-tests 'elem.task3)