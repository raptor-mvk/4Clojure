; Topic: core functions

(ns
  ^{:author "raptor_MVK"}
  core.task56
  (:use clojure.test))

(defn re-distinct
  "Reimplementation of 'distinct'"
  [coll]
  (let [counted (group-by identity coll)]
    (sort #(< (.indexOf coll %1) (.indexOf coll %2)) (keys counted))))

(deftest test1 (is (= (re-distinct [1 2 1 3 1 2 4]) [1 2 3 4])))

(deftest test2 (is (= (re-distinct [:a :a :b :b :c :c]) [:a :b :c])))

(deftest test3 (is (= (re-distinct '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))))

(deftest test4 (is (= (re-distinct (range 50)) (range 50))))

(run-tests 'core.task56)