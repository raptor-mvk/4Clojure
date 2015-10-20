; Topic: sequences

(ns
  ^{:author raptor_MVK}
  seqs.task67
  (:use clojure.test))

(defn primes-seq
  "Given N, returns first N prime numbers"
  [n]
  (loop [res [2]
         cur 3]
    (if (= n (count res))
      res
      (if-not (reduce #(or %1 %2) (map #(= 0 (mod cur %)) res))
        (recur (conj res cur) (inc cur))
        (recur res (inc cur))))))

(deftest test1 (is (= (primes-seq 2) [2 3])))

(deftest test2 (is (= (primes-seq 5) [2 3 5 7 11])))

(deftest test3 (is (= (last (primes-seq 100)) 541)))

(run-tests 'seqs.task67)