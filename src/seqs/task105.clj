; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task105
  (:use clojure.test))

(defn make-dict
  "Given an input sequence of keywords and numbers, create a map such that each key in the map is a keyword, and the
  value is a sequence of all the numbers (if any) between it and the next keyword in the sequence"
  [coll]
  (if (empty? coll)
    {}
    (loop [result {}
           tail coll]
      (if (empty? tail)
        result
        (let [key (first tail)
              values (take-while #(not (keyword? %)) (rest tail))]
          (recur (into result {key (vec values)}) (drop (inc (count values)) tail)))))))

(deftest test1 (is (= {} (make-dict []))))

(deftest test2 (is (= {:a [1]} (make-dict [:a 1]))))

(deftest test3 (is (= {:a [1], :b [2]} (make-dict [:a 1, :b 2]))))

(deftest test4 (is (= {:a [1 2 3], :b [], :c [4]} (make-dict [:a 1 2 3 :b :c 4]))))

(run-tests 'seqs.task105)