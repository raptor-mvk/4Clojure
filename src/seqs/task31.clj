; Topic: sequences

(ns
  ^{:author raptor}
  seqs.task31
  (:use clojure.test))

(defn pack-dup
  "Given a sequence, returns this sequence with packed into sub-lists consecutive
  duplicates"
  [coll]
  (partition-by identity coll))

(deftest test1 (is (= (pack-dup [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))))

(deftest test2 (is (= (pack-dup [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))))

(deftest test3 (is (= (pack-dup [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))))

(run-tests 'seqs.task31)