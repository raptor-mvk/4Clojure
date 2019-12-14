; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task52
  (:use clojure.test))

(defn func
  "Define function of five arguments that returns values of two of them and satisfies the given test condition"
  [_ _ c _ e]
  [c e])

(deftest test1 (is (= [2 4] (let [[a b c d e] [0 1 2 3 4]]  (func a b c d e)))))

(run-tests 'elem.task52)