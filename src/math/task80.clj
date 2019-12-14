; Topic: math

(ns
  ^{:author "raptor_MVK"}
  math.task80
  (:use clojure.test))

(defn perfect?
  "Given N, returns true, if N is perfect number"
  [n] (= n (reduce + (filter #(= 0 (mod n %)) (range 1 n)))))

(deftest test1 (is (= (perfect? 6) true)))

(deftest test2 (is (= (perfect? 7) false)))

(deftest test3 (is (= (perfect? 496) true)))

(deftest test4 (is (= (perfect? 500) false)))

(deftest test5 (is (= (perfect? 8128) true)))

(run-tests 'math.task80)