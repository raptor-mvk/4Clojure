; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task26
  (:use clojure.test))

(defn fib-seq
  "Returns the first N fibonacci numbers"
  [n]
  (let [next-fib (fn [[prev cur]] [cur (+ prev cur)])]
    (take n (map first (iterate next-fib [1 1])))))

(deftest test1 (is (= (fib-seq 3) '(1 1 2))))

(deftest test2 (is (= (fib-seq 6) '(1 1 2 3 5 8))))

(deftest test3 (is (= (fib-seq 8) '(1 1 2 3 5 8 13 21))))

(run-tests 'seqs.task26)