; Topic: math

(ns
  ^{:author "raptor_MVK"}
  math.task143
  (:use clojure.test))

(defn dot-product
  "Given two sequences of equal size, returns their dot product"
  [x y]
  (reduce + (map * x y)))

(deftest test1 (is (= 0 (dot-product [0 1 0] [1 0 0]))))

(deftest test2 (is (= 3 (dot-product [1 1 1] [1 1 1]))))

(deftest test3 (is (= 32 (dot-product [1 2 3] [4 5 6]))))

(deftest test4 (is (= 256 (dot-product [2 5 6] [100 10 1]))))

(run-tests 'math.task143)