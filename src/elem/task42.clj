; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task42
  (:use clojure.test))

(defn fact
  "Calculates factorial"
  [n]
  (reduce * (range 1 (inc n))))

(deftest test1 (is (= (fact 1) 1)))

(deftest test2 (is (= (fact 3) 6)))

(deftest test3 (is (= (fact 5) 120)))

(deftest test4 (is (= (fact 8) 40320)))

(run-tests 'elem.task42)