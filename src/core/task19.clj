; Topic: core functions

(ns
  ^{:author "raptor_MVK"}
  core.task19
  (:use clojure.test))

(defn re-last
  "Reimplementation of 'last'"
  [coll]
  (-> coll reverse first))

(deftest test1 (is (= (re-last [1 2 3 4 5]) 5)))

(deftest test2 (is (= (re-last '(5 4 3)) 3)))

(deftest test3 (is (= (re-last ["b" "c" "d"]) "d")))

(run-tests 'core.task19)