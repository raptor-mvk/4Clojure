; Topic: sequences

(ns
  ^{:author raptor}
  seqs.task28
  (:use clojure.test))

(defn re-flatten
  "Reimplementation of 'flatten'"
  [coll]
  (filter (complement sequential?) (tree-seq sequential? seq coll)))

(deftest test1 (is (= (re-flatten '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))))

(deftest test2 (is (= (re-flatten ["a" ["b"] "c"]) '("a" "b" "c"))))

(deftest test3 (is (= (re-flatten '((((:a))))) '(:a))))

(run-tests 'seqs.task28)