; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task65
  (:use clojure.test))

(defn get-type
  "Given a collection, returns its type as a keyword"
  [coll]
  (let [new-coll (into coll [{:z :x} {:z :x} {:z :y}])
        diff (- (count new-coll) (count coll))]
    (condp = diff
      1 :map ;
      2 :set ;
      (if (= {:z :y} (first new-coll)) :list :vector))))

(deftest test1 (is (= :map (get-type {:a 1, :b 2}))))

(deftest test2 (is (= :list (get-type (range (rand-int 20))))))

(deftest test3 (is (= :vector (get-type [1 2 3 4 5 6]))))

(deftest test4 (is (= :set (get-type #{10 (rand-int 5)}))))

(deftest test5 (is (= [:map :set :vector :list] (map get-type [{} #{} [] ()]))))

(run-tests 'seqs.task65)