; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task35
  (:use clojure.test))

(def result
  "Define value that satisfies the given test conditions"
  7)

(deftest test1 (is (= result (let [x 5] (+ 2 x)))))

(deftest test2 (is (= result (let [x 3, y 10] (- y x)))))

(deftest test3 (is (= result (let [x 21] (let [y 3] (/ x y))))))

(run-tests 'elem.task35)