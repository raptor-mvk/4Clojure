; Topic: core functions

(ns
  ^{:author "raptor_MVK"}
  core.task40
  (:use clojure.test))

(defn re-interpose
  "Reimplementation of 'interpose'"
  [sep coll]
  (butlast (interleave coll (take (count coll) (cycle [sep])))))

(deftest test1 (is (= (re-interpose 0 [1 2 3]) [1 0 2 0 3])))

(deftest test2 (is (= (apply str (re-interpose ", " ["one" "two" "three"]))
                     "one, two, three")))

(deftest test3 (is (= (re-interpose :z [:a :b :c :d]) [:a :z :b :z :c :z :d])))

(run-tests 'core.task40)