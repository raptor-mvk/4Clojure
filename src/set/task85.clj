; Topic: set theory

(ns
  ^{:author "raptor_MVK"}
  set.task85
  (:use clojure.test))

(defn power-set
  "Given a set, returns its power set"
  [coll]
  (let [n (count coll)
        mult (map #(int (Math/pow 2 %)) (take n (range)))
        int2set (fn [x coll] (into #{} (filter #(not (nil? %))
                                         (map #(when %1 %2)
                                           (map #(> (bit-and x %) 0) mult) coll))))]
    (into #{} (map #(int2set % coll) (take (Math/pow 2 n) (range))))))

(deftest test1 (is (= (power-set #{1 :a}) #{#{1 :a} #{:a} #{} #{1}})))

(deftest test2 (is (= (power-set #{}) #{#{}})))

(deftest test3 (is (= (power-set #{1 2 3})
                       #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}})))

(deftest test4 (is (= (count (power-set (into #{} (range 10)))) 1024)))

(run-tests 'set.task85)