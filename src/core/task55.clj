; Topic: core functions

(ns
  ^{:author "raptor_MVK"}
  core.task55
  (:use clojure.test))

(defn re-frequencies
  "Reimplementation of 'frequencies'"
  [coll]
  (reduce into (map #(hash-map (key %) (count (val %))) (group-by identity coll))))

(deftest test1 (is (= (re-frequencies [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1})))

(deftest test2 (is (= (re-frequencies [:b :a :b :a :b]) {:a 2, :b 3})))

(deftest test3 (is (= (re-frequencies '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})))

(run-tests 'core.task55)