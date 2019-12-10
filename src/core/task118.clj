; Topic: core functions

(ns
  ^{:author "raptor_MVK"}
  core.task118
  (:use clojure.test))

(defn re-map
  "Reimplementation of 'map'"
  [f x]
  (if (empty? x) '() (lazy-cat [(f (first x))] (re-map f (rest x)))))

(deftest test1 (is (= [3 4 5 6 7] (re-map inc [2 3 4 5 6]))))

(deftest test2 (is (= (repeat 10 nil) (re-map (fn [_] nil) (range 10)))))

(deftest test3 (is (= [1000000 1000001] (->> (re-map inc (range)) (drop (dec 1000000))
                                          (take 2)))))

(run-tests 'core.task118)