; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task14
  (:use clojure.test))

(def result
  "Define value that satisfies the given test conditions"
  8)

(deftest test1 (is (= result ((fn add-five [x] (+ x 5)) 3))))

(deftest test2 (is (= result ((fn [x] (+ x 5)) 3))))

(deftest test3 (is (= result (#(+ % 5) 3))))

(deftest test4 (is (= result ((partial + 5) 3))))

(run-tests 'elem.task14)