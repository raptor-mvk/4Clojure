; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task75
  (:use clojure.test))

(defn totient
  "Given N, returns Euler's Totient function value at N"
  [n]
  (let [gcd (fn gcd [x y]
              (if (= x 0)
                y
                (if (< x y)
                  (gcd (- y x) x)
                  (gcd (- x y) y))))]
    (if (= n 1)
      1
      (count (filter #(= 1 (gcd % n)) (rest (range n)))))))

(deftest test1 (is (= (totient 1) 1)))

(deftest test2 (is (= (totient 10) (count '(1 3 7 9)) 4)))

(deftest test3 (is (= (totient 40) 16)))

(deftest test4 (is (= (totient 99) 60)))

(run-tests 'elem.task75)