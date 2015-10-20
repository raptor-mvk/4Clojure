; Topic: core functions

(ns
  ^{:author raptor_MVK}
  core.task61
  (:use clojure.test))

(defn re-zipmap
  "Reimplementation of 'zipmap'"
  [keys values]
  (reduce into {} (map #(hash-map %1 %2) keys values)))

(deftest test1 (is (= (re-zipmap [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3})))

(deftest test2 (is (= (re-zipmap [1 2 3 4] ["one" "two" "three"])
                     {1 "one", 2 "two", 3 "three"})))

(deftest test3 (is (= (re-zipmap [:foo :bar] ["foo" "bar" "baz"])
                     {:foo "foo", :bar "bar"})))

(run-tests 'core.task61)