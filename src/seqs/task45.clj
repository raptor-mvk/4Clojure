; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task45
  (:use clojure.test))

(def value
  "Define value that satisfies the given test condition"
  '(1 4 7 10 13))

(deftest test1 (is (= value (take 5 (iterate #(+ 3 %) 1)))))

(run-tests 'seqs.task45)