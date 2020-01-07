; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task156
  (:use clojure.test))

(defn default-map
  "Given a default value and a sequence of keys, returns a map with default values for each key"
  [default keys]
  (apply hash-map (interleave keys (take (count keys) (cycle [default])))))

(deftest test1 (is (= (default-map 0 [:a :b :c]) {:a 0 :b 0 :c 0})))

(deftest test2 (is (= (default-map "x" [1 2 3]) {1 "x" 2 "x" 3 "x"})))

(deftest test3 (is (= (default-map [:a :b] [:foo :bar]) {:foo [:a :b] :bar [:a :b]})))

(run-tests 'elem.task156)