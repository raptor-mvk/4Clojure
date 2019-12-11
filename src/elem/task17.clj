; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task17
  (:use clojure.test))

(def result
  "Define value that satisfies the given test condition"
  '(6 7 8))

(deftest test1 (is (= result (map #(+ % 5) '(1 2 3)))))

(run-tests 'elem.task17)