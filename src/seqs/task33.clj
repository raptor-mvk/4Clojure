; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task33
  (:use clojure.test))

(defn repl
  "Given a sequence and a number N, replicates each element of a sequence N times"
  [coll n]
  (apply interleave (repeat n coll)))

(deftest test1 (is (= (repl [1 2 3] 2) '(1 1 2 2 3 3))))

(deftest test2 (is (= (repl [:a :b] 4) '(:a :a :a :a :b :b :b :b))))

(deftest test3 (is (= (repl [4 5 6] 1) '(4 5 6))))

(deftest test4 (is (= (repl [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))))

(deftest test5 (is (= (repl [44 33] 2) [44 44 33 33])))

(run-tests 'seqs.task33)