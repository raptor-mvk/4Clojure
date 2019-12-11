; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task47
  (:use clojure.test))

(def value
  "Define value that satisfies the given test conditions"
  4)

(deftest test1 (is (contains? #{4 5 6} value)))

(deftest test2 (is (contains? [1 1 1 1 1] value)))

(deftest test3 (is (contains? {4 :a 2 :b} value)))

(deftest test4 (is (not (contains? [1 2 4] value))))

(run-tests 'elem.task47)