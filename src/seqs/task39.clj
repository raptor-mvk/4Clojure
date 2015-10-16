; Topic: sequences

(ns
  ^{:author raptor}
  seqs.task39
  (:use clojure.test))

(defn re-interleave
  "Reimplementation of 'interleave'"
  [coll coll2]
  (flatten (map #(vector %1 %2) coll coll2)))

(deftest test1 (is (= (re-interleave [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))))

(deftest test2 (is (= (re-interleave [1 2] [3 4 5 6]) '(1 3 2 4))))

(deftest test3 (is (= (re-interleave [1 2 3 4] [5]) [1 5])))

(deftest test4 (is (= (re-interleave [30 20] [25 15]) [30 25 20 15])))

(run-tests 'seqs.task39)