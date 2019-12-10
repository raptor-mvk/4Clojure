; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task83
  (:use clojure.test))

(defn or-not-and
  "Given a variable number of booleans, returns true if some of the parameters are
  true, but not all of the parameters are true, otherwise returns false"
  [& x] (and (not (reduce #(and %1 %2) x)) (reduce #(or %1 %2) x)))

(deftest test1 (is (= false (or-not-and false false))))

(deftest test2 (is (= true (or-not-and true false))))

(deftest test3 (is (= false (or-not-and true))))

(deftest test4 (is (= true (or-not-and false true false))))

(deftest test5 (is (= false (or-not-and true true true))))

(deftest test6 (is (= true (or-not-and true true true false))))

(run-tests 'seqs.task83)