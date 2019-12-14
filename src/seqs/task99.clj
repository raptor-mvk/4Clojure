; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task99
  (:use clojure.test))

(defn product-sequence
  "Given two numbers, returns their product as a sequence of its digits"
  [x y]
  (read-string (clojure.string/join " " (str "[" (* x y) "]"))))

(deftest test1 (is (= (product-sequence 1 1) [1])))

(deftest test2 (is (= (product-sequence 99 9) [8 9 1])))

(deftest test3 (is (= (product-sequence 999 99) [9 8 9 0 1])))

(run-tests 'seqs.task99)