; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task72
  (:use clojure.test))

(defn func
  "Define function that satisfies the given test condition"
  [arr]
  (reduce + arr))

(deftest test1 (is (= (func (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
                      (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (func))
                      11)))

(run-tests 'elem.task72)