; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task18
  (:use clojure.test))

(def result
  "Define value that satisfies the given test condition"
  '(6 7))

(deftest test1 (is (= result (filter #(> % 5) '(3 4 5 6 7)))))

(run-tests 'elem.task18)