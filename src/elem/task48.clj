; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task48
  (:use clojure.test))

(def value
  "Define value that satisfies the given test conditions"
  6)

(deftest test1 (is (= value (some #{2 7 6} [5 6 7 8]))))

(deftest test2 (is (= value (some #(when (even? %) %) [5 6 7 8]))))

(run-tests 'elem.task48)