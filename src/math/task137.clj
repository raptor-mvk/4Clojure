; Topic: math

(ns
  ^{:author "raptor_MVK"}
  math.task137
  (:use clojure.test))

(defn convert-int-to-base-seq
  "Returns a sequence of digits of a non-negative number (first argument) in numerical system with an arbitrary base
  (second argument)"
  [n base]
  (loop [res '()
         cur n]
    (if (< cur base)
      (conj res cur)
      (recur (conj res (mod cur base)) (int (/ cur base))))))

(deftest test1 (is (= [1 2 3 4 5 0 1] (convert-int-to-base-seq 1234501 10))))

(deftest test2 (is (= [0] (convert-int-to-base-seq 0 11))))

(deftest test3 (is (= [1 0 0 1] (convert-int-to-base-seq 9 2))))

(deftest test4 (is (= [1 0] (let [n (rand-int 100000)](convert-int-to-base-seq n n)))))

(deftest test5 (is (= [16 18 5 24 15 1] (convert-int-to-base-seq Integer/MAX_VALUE 42))))

(run-tests 'math.task137)