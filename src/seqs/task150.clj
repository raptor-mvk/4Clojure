; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task150
  (:use clojure.test))

(defn palindrom
  "Given a number, returns an increasing lazy sequence of all palindromic numbers
  that are not less than that number"
  [n] (and (not (reduce #(and %1 %2) x)) (reduce #(or %1 %2) x)))

(deftest test1 (is (= (take 26 (palindrom 0))
   [0 1 2 3 4 5 6 7 8 9 11 22 33 44 55 66 77 88 99 101 111 121 131 141 151 161])))

(deftest test2 (is (= true (or-not-and true false))))

(deftest test3 (is (= false (or-not-and true))))

(deftest test4 (is (= true (or-not-and false true false))))

(deftest test5 (is (= false (or-not-and true true true))))

(deftest test6 (is (= true (or-not-and true true true false))))

(run-tests 'seqs.task83)