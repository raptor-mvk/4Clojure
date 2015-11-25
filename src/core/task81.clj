; Topic: core functions

(ns
  ^{:author raptor_MVK}
  core.task81
  (:use clojure.set)
  (:use clojure.test))

(defn re-intersection
  "Reimplementation of 'intersection'"
  [x y] (clojure.set/difference x (clojure.set/difference x y)))

(deftest test1 (is (= (re-intersection #{0 1 2 3} #{2 3 4 5}) #{2 3})))

(deftest test2 (is (= (re-intersection #{0 1 2} #{3 4 5}) #{})))

(deftest test3 (is (= (re-intersection #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d})))

(run-tests 'core.task81)