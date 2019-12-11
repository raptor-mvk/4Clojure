; Topic: core functions

(ns
  ^{:author "raptor_MVK"}
  core.task60
  (:use clojure.test))

(defn re-reductions
  "Reimplementation of 'reductions'"
  ([f coll]
   (re-reductions f (first coll) (rest coll)))
  ([f init coll]
   (if (empty? coll)
     [init]
     (lazy-cat [init] (re-reductions f (f init (first coll)) (rest coll))))))

(deftest test1 (is (= (take 5 (re-reductions + (range))) [0 1 3 6 10])))

(deftest test2 (is (= (re-reductions conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])))

(deftest test3 (is (= (last (re-reductions * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)))

(run-tests 'core.task60)