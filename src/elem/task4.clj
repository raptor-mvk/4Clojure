; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task4
  (:use clojure.test))

(def value
  "Define value that satisfies the given test condition using template (list __)"
  (list :a :b :c))

(deftest test1 (is (= value '(:a :b :c))))

(run-tests 'elem.task4)