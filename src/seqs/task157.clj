; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task157
  (:use clojure.test))

(defn index-seq
  "Given a sequence, returns a sequence of pairs containing the original elements along with their index"
  [seq]
  (map #(vector %1 %2) seq (range)))

(deftest test1 (is (= (index-seq [:a :b :c]) [[:a 0] [:b 1] [:c 2]])))

(deftest test2 (is (= (index-seq [0 1 3]) '((0 0) (1 1) (3 2)))))

(deftest test3 (is (= (index-seq [[:foo] {:bar :baz}]) [[[:foo] 0] [{:bar :baz} 1]])))

(run-tests 'seqs.task157)