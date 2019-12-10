; Topic: core functions

(ns
  ^{:author "raptor_MVK"}
  core.task62
  (:use clojure.test))

(defn re-iterate
  "Reimplementation of 'iterate'"
  [f x]
  (lazy-cat [x] (re-iterate f (f x))))

(deftest test1 (is (= (take 5 (re-iterate #(* 2 %) 1)) [1 2 4 8 16])))

(deftest test2 (is (= (take 100 (re-iterate inc 0)) (take 100 (range)))))

(deftest test3 (is (= (take 9 (re-iterate #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))))

(run-tests 'core.task62)