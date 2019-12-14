; Topic: math

(ns
  ^{:author "raptor_MVK"}
  math.task97
  (:use clojure.test))

(defn pascal-triangle-row
  "Given a number n, returns the nth row of Pascal's Triangle"
  [n]
  (let [next-row (fn [x] (map #(+ %1 %2) (concat x [0]) (concat [0] x)))]
    (nth (iterate next-row [1]) (dec n))))

(deftest test1 (is (= (pascal-triangle-row 1) [1])))

(deftest test2 (is (= (map pascal-triangle-row (range 1 6))
                      [[1]
                       [1 1]
                       [1 2 1]
                       [1 3 3 1]
                       [1 4 6 4 1]])))

(deftest test3 (is (= (pascal-triangle-row 11) [1 10 45 120 210 252 210 120 45 10 1])))

(run-tests 'math.task97)