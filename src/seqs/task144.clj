; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task144
  (:use clojure.test))

(defn oscilrate
  "Given an initial value and a variable number of functions, returns a lazy sequence of the functions applied to the
  value in order, restarting from the first function after it hits the end"
  [x & f]
  (reductions #(%2 %1) x (cycle f)))

(deftest test1 (is (= (take 3 (oscilrate 3.14 int double)) [3.14 3 3.0])))

(deftest test2 (is (= (take 5 (oscilrate 3 #(- % 3) #(+ 5 %))) [3 0 5 2 7])))

(deftest test3 (is (= (take 12 (oscilrate 0 inc dec inc dec inc)) [0 1 0 1 0 1 2 1 2 1 2 3])))

(run-tests 'seqs.task144)