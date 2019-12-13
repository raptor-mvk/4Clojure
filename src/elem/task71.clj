; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task71
  (:use clojure.test))

(def func
  "Define function that satisfies the given test condition"
  last)

(deftest test1 (is (= (func (sort (rest (reverse [2 5 4 1 3 6]))))
                   (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (func))
                   5)))

(run-tests 'elem.task71)