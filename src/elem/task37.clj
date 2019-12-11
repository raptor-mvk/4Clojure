; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task37
  (:use clojure.test))

(def value
  "Define value that satisfies the given test condition"
  "ABC")

(deftest test1 (is (= value (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))))

(run-tests 'elem.task37)