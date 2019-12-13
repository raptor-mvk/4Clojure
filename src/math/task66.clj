; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  math.task66
  (:use clojure.test))

(defn gcd
  "Given two integers, returns the greatest common divisor"
  [m n]
  (cond
    (= m n) m                                               ;
    (< m n) (gcd (- n m) m)                                 ;
    :else (gcd (- m n) n)))

(deftest test1 (is (= (gcd 2 4) 2)))

(deftest test2 (is (= (gcd 10 5) 5)))

(deftest test3 (is (= (gcd 5 7) 1)))

(deftest test4 (is (= (gcd 1023 858) 33)))

(run-tests 'math.task66)