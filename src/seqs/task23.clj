; Topic: sequences

(ns
  ^{:author raptor}
  seqs.task23
  (:use clojure.test))

(defn re-reverse
  "Reimplementation of 'reverse'"
  [coll] (reduce conj '() coll))

(deftest test1 (is (= (re-reverse [1 2 3 4 5]) [5 4 3 2 1])))

(deftest test2 (is (= (re-reverse (sorted-set 5 7 2 7))
                     '(7 5 2))))

(deftest test3 (is (= (re-reverse [[1 2][3 4][5 6]])
                     [[5 6][3 4][1 2]])))

(run-tests 'seqs.task23)