; Topic: core functions

(ns
  ^{:author raptor_MVK}
  core.task59
  (:use clojure.test))

(defn re-juxt
  "Reimplementation of 'juxt'"
  [& f]
  (fn [& x] (map #(apply % x) f)))

(deftest test1 (is (= [21 6 1] ((re-juxt + max min) 2 3 5 1 6 4))))

(deftest test2 (is (= ["HELLO" 5] ((re-juxt #(.toUpperCase %) count) "hello"))))

(deftest test3 (is (= [2 6 4] ((re-juxt :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))))

(run-tests 'core.task59)