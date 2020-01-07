; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task161
  (:use clojure.set)
  (:use clojure.test))

(def value
  "Define value that satisfies the given test conditions"
  #{1 2})

(deftest test1 (is (clojure.set/superset? value #{2})))

(deftest test2 (is (clojure.set/subset? #{1} value)))

(deftest test3 (is (clojure.set/superset? value #{1 2})))

(deftest test4 (is (clojure.set/subset? #{1 2} value)))

(run-tests 'elem.task161)