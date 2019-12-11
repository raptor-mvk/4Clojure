; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task11
  (:use clojure.test))

(def result
  "Define value that satisfies the given test condition"
  [:b 2])

(deftest test1 (is (= {:a 1, :b 2, :c 3} (conj {:a 1} result [:c 3]))))

(run-tests 'elem.task11)