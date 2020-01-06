; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task134
  (:use clojure.test))

(defn has-nil-value?
  "Given a key and map, returns true iff the map contains an entry with that key and its value is nil"
  [key map]
  (and (contains? map key) (= (get map key) nil)))

(deftest test1 (is (true? (has-nil-value? :a {:a nil :b 2}))))

(deftest test2 (is (false? (has-nil-value? :b {:a nil :b 2}))))

(deftest test3 (is (false? (has-nil-value? :c {:a nil :b 2}))))

(run-tests 'elem.task134)