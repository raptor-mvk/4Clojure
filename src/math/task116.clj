; Topic: math

(ns
  ^{:author "raptor_MVK"}
  math.task116
  (:use clojure.test))

(defn balanced-prime?
  "Given an integer n, and returns true iff it is a balanced prime (a prime number which is also the mean of the primes
  directly before and after it in the sequence of valid primes)"
  [n]
  (let [prime? (fn [n] (every? #(> (mod n %) 0) (range 2 n)))]
    (if (and (> n 4) (prime? n))
      (let [next (some #(and (prime? %) %) (drop (inc n) (range)))
            prev (some #(and (prime? %) %) (reverse (range 2 n)))]
        (= n (/ (+ next prev) 2)))
      false)))

(deftest test1 (is (= false (balanced-prime? 4))))

(deftest test2 (is (= true (balanced-prime? 563))))

(deftest test3 (is (= 1103 (nth (filter balanced-prime? (range)) 15))))

(run-tests 'math.task116)