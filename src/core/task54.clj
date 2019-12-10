; Topic: core functions

(ns
  ^{:author "raptor_MVK"}
  core.task54
  (:use clojure.test))

(defn re-partition
  "Reimplementation of 'partition' with two arguments"
  [n coll]
  (loop [cur coll
         res []]
    (if (>= (count cur) n)
      (recur (drop n cur) (into res (list (take n cur))))
      res)))

(deftest test1 (is (= (re-partition 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8)))))

(deftest test2 (is (= (re-partition 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))))

(deftest test3 (is (= (re-partition 3 (range 8)) '((0 1 2) (3 4 5)))))

(run-tests 'core.task54)