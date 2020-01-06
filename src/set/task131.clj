; Topic: set theory

(ns
  ^{:author "raptor_MVK"}
  set.task131
  (:use clojure.set)
  (:use clojure.test))

(defn has-common-non-empty-subset-with-equal-sum?
  "Given a variable number of sets of integers, returns true iff all of the sets have a non-empty subset with an
  equivalent summation"
  [& coll]
  (let [get-subsets-sums (fn [coll] (let [n (count coll)
                                          powers-of-2 (map #(int (Math/pow 2 %)) (range (inc n)))
                                          int2set (fn [x coll]
                                                    (into #{} (filter #(not (nil? %))
                                                                      (map #(when %1 %2)
                                                                           (map #(> (bit-and x %) 0)
                                                                                powers-of-2) coll))))]
                                      (into #{} (map #(reduce + (int2set % coll))
                                                     (rest (take (Math/pow 2 n) (range)))))))]
    (not (empty? (reduce clojure.set/intersection (map get-subsets-sums coll))))))

; all sets have a subset which sums to zero
(deftest test1 (is (= true (has-common-non-empty-subset-with-equal-sum? #{-1 1 99} #{-2 2 888} #{-3 3 7777}))))

(deftest test2 (is (= false (has-common-non-empty-subset-with-equal-sum? #{1} #{2} #{3} #{4}))))

(deftest test3 (is (= true (has-common-non-empty-subset-with-equal-sum? #{1}))))

(deftest test4 (is (= false (has-common-non-empty-subset-with-equal-sum? #{1 -3 51 9} #{0} #{9 2 81 33}))))

(deftest test5 (is (= true (has-common-non-empty-subset-with-equal-sum? #{1 3 5} #{9 11 4} #{-3 12 3} #{-3 4 -2 10}))))

(deftest test6 (is (= false (has-common-non-empty-subset-with-equal-sum? #{-1 -2 -3 -4 -5 -6} #{1 2 3 4 5 6 7 8 9}))))

(deftest test7 (is (= true (has-common-non-empty-subset-with-equal-sum? #{1 3 5 7} #{2 4 6 8}))))

(deftest test8 (is (= true (has-common-non-empty-subset-with-equal-sum? #{-1 3 -5 7 -9 11 -13 15}
                                                                        #{1 -3 5 -7 9 -11 13 -15}
                                                                        #{1 -1 2 -2 4 -4 8 -8}))))

(deftest test9 (is (= true (has-common-non-empty-subset-with-equal-sum? #{-10 9 -8 7 -6 5 -4 3 -2 1}
                                                                        #{10 -9 8 -7 6 -5 4 -3 2 -1}))))

(run-tests 'set.task131)