; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task147
  (:use clojure.test))

(defn pascal-trapezoid
  "Given input vector of numbers, returns an infinite lazy sequence of vectors, where each next one is constructed from
  the previous following the rules used in Pascal's Triangle"
  [seq]
  (iterate #(map +' (concat % [0]) (concat [0] %)) seq))

(deftest test1 (is (= (second (pascal-trapezoid [2 3 2])) [2 5 5 2])))

(deftest test2 (is (= (take 5 (pascal-trapezoid [1])) [[1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1]])))

(deftest test3 (is (= (take 2 (pascal-trapezoid [3 1 2])) [[3 1 2] [3 4 3 2]])))

(deftest test4 (is (= (take 100 (pascal-trapezoid [2 4 2])) (rest (take 101 (pascal-trapezoid [2 2]))))))

(run-tests 'seqs.task147)