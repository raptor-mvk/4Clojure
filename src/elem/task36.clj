; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task36
  (:use clojure.test))

(def values
  "Define value that satisfies the given test conditions"
  {:x 7 :y 3 :z 1})

(deftest test1 (is (= 10 (let [{:keys  [x y z]} values] (+ x y)))))

(deftest test2 (is (= 4 (let [{:keys  [x y z]} values] (+ y z)))))

(deftest test3 (is (= 1 (let [{:keys  [x y z]} values] z))))

(run-tests 'elem.task36)