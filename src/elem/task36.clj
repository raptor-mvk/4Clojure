; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task36
  (:use clojure.test))

(def values
  "Define value that satisfies the given test conditions"
  [7 3 1])

(deftest test1 (is (= 10 (let [[x y _] values] (+ x y)))))

(deftest test2 (is (= 4 (let [[_ y z] values] (+ y z)))))

(deftest test3 (is (= 1 (let [[_ _ z] values] z))))

(run-tests 'elem.task36)