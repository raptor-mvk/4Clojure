; Topic: math

(ns
  ^{:author "raptor_MVK"}
  math.task135
  (:use clojure.test))

(defn infix-calc
  "Given a variable length mathematical expression consisting of numbers and the operations +, -, *, and /, returns
  evaluated result of this expression (there is no precedence, just calculation from left to right)"
  [& x]
  (if (= (count x) 1)
    (first x)
    (let [without-last (butlast x)
          left (apply infix-calc (butlast without-last))]
      ((last without-last) left (last x)))))

(deftest test1 (is (= 7  (infix-calc 2 + 5))))

(deftest test2 (is (= 42 (infix-calc 38 + 48 - 2 / 2))))

(deftest test3 (is (= 8  (infix-calc 10 / 2 - 1 * 2))))

(deftest test4 (is (= 72 (infix-calc 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9))))

(run-tests 'math.task135)