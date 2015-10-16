; Topic: elementary

(ns
  ^{:author raptor_MVK}
  elem.task38
  (:use clojure.test))

(defn re-max
  "Reimplementation of 'max'"
  [& coll]
  (reduce #(if (> %2 %1) %2 %1) coll))

(deftest test1 (is (= (re-max 1 8 3 4) 8)))

(deftest test2 (is (= (re-max  30 20) 30)))

(deftest test3 (is (= (re-max 45 67 11) 67)))

(run-tests 'elem.task38)