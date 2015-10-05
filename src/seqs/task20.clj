; Topic: sequences

(ns
  ^{:author raptor}
  seqs.task20
  (:use clojure.test))

(defn prelast
  "Returns the second to last element from a sequence"
  [x] (-> x reverse second))

(deftest test1 (is (= (prelast (list 1 2 3 4 5)) 4)))

(deftest test2 (is (= (prelast ["a" "b" "c"]) "b")))

(deftest test3 (is (= (prelast [[1 2] [3 4]]) [1 2])))

(run-tests 'seqs.task20)