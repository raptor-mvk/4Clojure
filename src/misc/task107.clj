; Topic: miscellaneous

(ns
  ^{:author "raptor_MVK"}
  misc.task107
  (:use clojure.test))

(defn power-closure
  "Given n, returns function f(x)=x^n"
  [n] (fn [x] (reduce * 1 (take n (cycle [x])))))

(deftest test1 (is (= 256 ((power-closure 2) 16) ((power-closure 8) 2))))

(deftest test2 (is (= [1 8 27 64] (map (power-closure 3) [1 2 3 4]))))

(deftest test3 (is (= [1 2 4 8 16] (map #((power-closure %) 2) [0 1 2 3 4]))))

(run-tests 'misc.task107)