; Topic: sequences

(ns
  ^{:author raptor_MVK}
  seqs.task50
  (:use clojure.test))

(defn split-by-type
  "Given a sequence, returns set of sub-sequences, grouped by item type"
  [coll]
  (reduce #(into %1 (vector (last %2))) #{} (group-by class coll)))

(deftest test1 (is (= (set (split-by-type [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})))

(deftest test2 (is (= (set (split-by-type [:a "foo" "bar" :b]))
                       #{[:a :b] ["foo" "bar"]})))

(deftest test3 (is (= (set (split-by-type [[1 2] :a [3 4] 5 6 :b]))
                       #{[[1 2] [3 4]] [:a :b] [5 6]})))

(run-tests 'seqs.task50)