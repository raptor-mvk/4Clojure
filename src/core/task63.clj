; Topic: core functions

(ns
  ^{:author "raptor_MVK"}
  core.task63
  (:use clojure.test))

(defn re-group-by
  "Reimplementation of 'group-by'"
  [f x]
  (apply merge-with concat (map #(hash-map (f %) [%]) x)))

(deftest test1 (is (= (re-group-by #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]})))

(deftest test2 (is (= (re-group-by #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
                      {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})))

(deftest test3 (is (= (re-group-by count [[1] [1 2] [3] [1 2 3] [2 3]])
                      {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})))

(run-tests 'core.task63)