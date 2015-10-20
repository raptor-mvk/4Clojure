; Topic: sequences

(ns
  ^{:author raptor}
  seqs.task49
  (:use clojure.test))

(defn re-split-at
  "Reimplementation of 'split-at'"
  [n coll]
  [(take n coll) (drop n coll)])

(deftest test1 (is (= (re-split-at 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])))

(deftest test2 (is (= (re-split-at 1 [:a :b :c :d]) [[:a] [:b :c :d]])))

(deftest test3 (is (= (re-split-at 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])))

(run-tests 'seqs.task49)