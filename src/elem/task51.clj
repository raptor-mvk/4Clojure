; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task51
  (:use clojure.test))

(def values
  "Define value that satisfies the given test condition"
  [1 2 3 4 5])

(deftest test1 (is (= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] values] [a b c d]))))

(run-tests 'elem.task51)