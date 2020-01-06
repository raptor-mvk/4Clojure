; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task126
  (:use clojure.test))

(def result
  "Define value that satisfies the given test condition"
  java.lang.Class)

(deftest test1 (is (and (= (class result) result) result)))

(run-tests 'elem.task126)