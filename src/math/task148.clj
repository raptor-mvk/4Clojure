; Topic: math

(ns
  ^{:author "raptor_MVK"}
  math.task148
  (:use clojure.test))

(defn get-sum-of-divisibles
  "Returns the sum of all natural numbers under n (first argument) which are evenly divisible by at least one of a and b
  (second and third argument). Numbers a and b are guaranteed to be coprimes"
  [n a b]
  (let [divisible-by-a-count (quot (dec n) a)
        divisible-by-b-count (quot (dec n) b)
        a-dot-b (*' a b)
        divisible-by-a-and-b-count (quot n a-dot-b)
        sum-count (fn [n n-count]
                    (quot (*' n n-count (inc n-count)) 2))]
    (-' (+' (sum-count a divisible-by-a-count) (sum-count b divisible-by-b-count))
        (sum-count a-dot-b divisible-by-a-and-b-count))))

(deftest test1 (is (= 0 (get-sum-of-divisibles 3 17 11))))

(deftest test2 (is (= 23 (get-sum-of-divisibles 10 3 5))))

(deftest test3 (is (= 233168 (get-sum-of-divisibles 1000 3 5))))

(deftest test4 (is (= "2333333316666668" (str (get-sum-of-divisibles 100000000 3 5)))))

(deftest test5 (is (= "110389610389889610389610" (str (get-sum-of-divisibles (* 10000 10000 10000) 7 11)))))

(deftest test6 (is (= "1277732511922987429116" (str (get-sum-of-divisibles (* 10000 10000 10000) 757 809)))))

(deftest test7 (is (= "4530161696788274281" (str (get-sum-of-divisibles (* 10000 10000 1000) 1597 3571)))))

(run-tests 'math.task148)