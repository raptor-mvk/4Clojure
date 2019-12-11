; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task9
  (:use clojure.test))

(def result
  "Define value that satisfies the given test condition"
  2)

(deftest test1 (is (= #{1 2 3 4} (conj #{1 4 3} result))))

(run-tests 'elem.task9)