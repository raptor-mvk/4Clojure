; Topic: core functions

(ns
  ^{:author raptor_MVK}
  core.task58
  (:use clojure.test))

(defn re-comp
  "Reimplementation of 'comp'"
  [& f]
  (fn [& x] (reduce #(%2 %1) (apply (last f) x) (rest (reverse f)))))

(deftest test1 (is (= [3 2 1] ((re-comp rest reverse) [1 2 3 4]))))

(deftest test2 (is (= 5 ((re-comp (partial + 3) second) [1 2 3 4]))))

(deftest test3 (is (= true ((re-comp zero? #(mod % 8) +) 3 5 7 9))))

(deftest test4 (is (= "HELLO"
                     ((re-comp #(.toUpperCase %) #(apply str %) take) 5 "hello world"))))

(run-tests 'core.task58)