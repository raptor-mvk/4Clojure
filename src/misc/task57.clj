; Topic: miscellaneous

(ns
  ^{:author "raptor_MVK"}
  misc.task57
  (:use clojure.test))

(def values
  "Define value that satisfies the given test condition"
  '(5 4 3 2 1))

(deftest test1 (is (= values ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))))

(run-tests 'misc.task57)