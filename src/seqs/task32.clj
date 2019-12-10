; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task32
  (:use clojure.test))

(defn dup
  "Duplicates each element of a sequence"
  [coll]
  (interleave coll coll))

(deftest test1 (is (= (dup [1 2 3]) '(1 1 2 2 3 3))))

(deftest test2 (is (= (dup [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))))

(deftest test3 (is (= (dup [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))))

(run-tests 'seqs.task32)