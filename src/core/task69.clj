; Topic: core functions

(ns
  ^{:author "raptor_MVK"}
  core.task69
  (:use clojure.test))

(defn re-merge-with
  "Reimplementation of 'merge-with'"
  [f & args]
  (let [upd (fn [coll x]
              (let [old (get-in coll [(key x)])]
                (if (nil? old)
                  x
                  (hash-map (key x) (f old (val x))))))
        upd-map (fn [coll1 coll2] (map #(upd coll1 %) coll2))]
    (reduce #(into %1 (upd-map %1 %2)) args)))

(deftest test1 (is (= (re-merge-with * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})
                     {:a 4, :b 6, :c 20})))

(deftest test2 (is (= (re-merge-with - {1 10, 2 20} {1 3, 2 10, 3 15})
                     {1 7, 2 10, 3 15})))

(deftest test3 (is (= (re-merge-with concat {:a [3], :b [6]}
                        {:a [4 5], :c [8 9]} {:b [7]}) {:a [3 4 5], :b [6 7], :c [8 9]})))

(run-tests 'core.task69)