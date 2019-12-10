; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task30
  (:use clojure.test))

(defn dedup
  "Given a collection, returns this collection with dropped consecutive deduplicates"
  [coll]
  (reverse (reduce #(if (= (first %1) %2) %1 (conj %1 %2)) '() coll)))

(deftest test1 (is (= (apply str (dedup "Leeeeeerrroyyy")) "Leroy")))

(deftest test2 (is (= (dedup [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))))

(deftest test3 (is (= (dedup [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))))

(run-tests 'seqs.task30)