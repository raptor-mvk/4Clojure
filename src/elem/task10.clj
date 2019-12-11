; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task10
  (:use clojure.test))

(def result
  "Define value that satisfies the given test conditions"
  20)

(deftest test1 (is (= result ((hash-map :a 10, :b 20, :c 30) :b))))

(deftest test2 (is (= result (:b {:a 10, :b 20, :c 30}))))

(run-tests 'elem.task10)