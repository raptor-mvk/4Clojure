; Topic: math

(ns
  ^{:author "raptor_MVK"}
  math.task100
  (:use clojure.test))

(defn calc-lcm
  "Given a variable number of positive integers or ratios, returns their least common multiple"
  [& x]
  (let [numerators (map #(if (ratio? %) (numerator %) %) x)
        denominators (map #(if (ratio? %) (denominator %) 1) x)
        find-gcd (fn gcd [x y]
               (if (= x 0)
                 y
                 (if (< x y)
                   (gcd (- y x) x)
                   (gcd (- x y) y))))
        gcd-numerators (reduce find-gcd numerators)
        gcd-denominators (reduce find-gcd denominators)]
    (reduce #(/ (* %1 %2) gcd-numerators) (/ gcd-numerators gcd-denominators) numerators)))

(deftest test1 (is (== (calc-lcm 2 3) 6)))

(deftest test2 (is (== (calc-lcm 5 3 7) 105)))

(deftest test3 (is (== (calc-lcm 1/3 2/5) 2)))

(deftest test4 (is (== (calc-lcm 3/4 1/6) 3/2)))

(deftest test5 (is (== (calc-lcm 7 5/7 2 3/5) 210)))

(run-tests 'math.task100)