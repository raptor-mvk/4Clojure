; Topic: set theory

(ns
  ^{:author raptor_MVK}
  set.task88
  (:use clojure.set)
  (:use clojure.test))

(defn sym-difference
  "Given two sets, returns their symmetric difference"
  [x y] (clojure.set/union (clojure.set/difference x y) (clojure.set/difference y x)))

(deftest test1 (is (= (sym-difference #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})))

(deftest test2 (is (= (sym-difference #{:a :b :c} #{}) #{:a :b :c})))

(deftest test3 (is (= (sym-difference #{} #{4 5 6}) #{4 5 6})))

(deftest test4 (is (= (sym-difference #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})))

(run-tests 'set.task88)