; Topic: sequences

(ns
  ^{:author raptor_MVK}
  seqs.task44
  (:use clojure.test))

(defn cycle-shift
  "Given a number N and a sequence, returns a sequence, that cyclically shifted by N
  elements in appropriate direction"
  [n coll]
  (let [start (mod n (count coll))]
    (concat (drop start coll) (take start coll))))

(deftest test1 (is (= (cycle-shift 2 [1 2 3 4 5]) '(3 4 5 1 2))))

(deftest test2 (is (= (cycle-shift -2 [1 2 3 4 5]) '(4 5 1 2 3))))

(deftest test3 (is (= (cycle-shift 6 [1 2 3 4 5]) '(2 3 4 5 1))))

(deftest test4 (is (= (cycle-shift 1 '(:a :b :c)) '(:b :c :a))))

(deftest test5 (is (= (cycle-shift -4 '(:a :b :c)) '(:c :a :b))))

(run-tests 'seqs.task44)