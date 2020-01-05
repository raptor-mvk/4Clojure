; Topic: math

(ns
  ^{:author "raptor_MVK"}
  math.task120
  (:use clojure.test))

(defn get-count-smaller-than-squared-digits
  "Given a collection of integers, returns the count of how many elements are smaller than the sum of their squared
  component digits"
  [coll]
  (let [ch2int #(- (int %) (int \0))
        sqr #(* % %)
        sqri (fn [x] (reduce + (map #(sqr (ch2int %)) (str x))))]
    (count (filter #(< (first %) (last %)) (map #(vector % (sqri %)) coll)))))

(deftest test1 (is (= 8 (get-count-smaller-than-squared-digits (range 10)))))

(deftest test2 (is (= 19 (get-count-smaller-than-squared-digits (range 30)))))

(deftest test3 (is (= 50 (get-count-smaller-than-squared-digits (range 100)))))

(deftest test4 (is (= 50 (get-count-smaller-than-squared-digits (range 1000)))))

(run-tests 'math.task120)