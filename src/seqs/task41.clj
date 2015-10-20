; Topic: sequences

(ns
  ^{:author raptor_MVK}
  seqs.task41
  (:use clojure.test))

(defn drop-nth
  "Given a sequence and a number N, drops every Nth item from a sequence"
  [coll n]
  (flatten (partition-all (dec n) n coll)))

(deftest test1 (is (= (drop-nth [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])))

(deftest test2 (is (= (drop-nth [:a :b :c :d :e :f] 2) [:a :c :e])))

(deftest test3 (is (= (drop-nth [1 2 3 4 5 6] 4) [1 2 3 5 6])))

(run-tests 'seqs.task41)