; Topic: high-order functions

(ns
  ^{:author "raptor_MVK"}
  elem.task46
  (:use clojure.test))

(defn arg-flip
  "Given a function, returns function with flipped order of arguments"
  [f]
  (fn [x y] (f y x)))

(deftest test1 (is (= 3 ((arg-flip nth) 2 [1 2 3 4 5]))))

(deftest test2 (is (= true ((arg-flip >) 7 8))))

(deftest test3 (is (= 4 ((arg-flip quot) 2 8))))

(deftest test4 (is (= [1 2 3] ((arg-flip take) [1 2 3 4 5] 3))))

(run-tests 'elem.task46)