; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task45
  (:use clojure.test))

(def value
  "Define value that satisfies the given test condition"
  '(1 4 7 10 13))

(deftest test1 (is (= value (take 5 (iterate #(+ 3 %) 1)))))

(run-tests 'elem.task45)