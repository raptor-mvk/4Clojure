; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task110
  (:use clojure.test))

(defn pronounce-seq
  "Given an initial sequence of numbers, returns an infinite lazy sequence of pronunciations, each element being a
  pronunciation of the previous element"
  [coll]
  (let [next (fn [coll] (reduce #(into %1 [(count %2) (first %2)])
                                [] (partition-by identity coll)))]
    (drop 1 (iterate next coll))))

(deftest test1 (is (= [[1 1] [2 1] [1 2 1 1]] (take 3 (pronounce-seq [1])))))

(deftest test2 (is (= [3 1 2 4] (first (pronounce-seq [1 1 1 4 4])))))

(deftest test3 (is (= [1 1 1 3 2 1 3 2 1 1] (nth (pronounce-seq [1]) 6))))

(deftest test4 (is (= 338 (count (nth (pronounce-seq [3 2]) 15)))))

(run-tests 'seqs.task110)