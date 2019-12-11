; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task7
  (:use clojure.test))

(def result
  "Define value that satisfies the given test conditions"
  [1 2 3 4])

(deftest test1 (is (= result (conj [1 2 3] 4))))

(deftest test2 (is (= result (conj [1 2] 3 4))))

(run-tests 'elem.task7)