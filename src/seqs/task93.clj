; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task93
  (:use clojure.test))

(defn part-flatten
  "Given a nested sequence, returns sequence with only one level of nesting"
  [coll]
  (filter #(and (coll? %) (not-any? sequential? %)) (tree-seq sequential? seq coll)))

(deftest test1 (is (= (part-flatten [["Do"] ["Nothing"]]) [["Do"] ["Nothing"]])))

(deftest test2 (is (= (part-flatten [[[[:a :b]]] [[:c :d]] [:e :f]]) [[:a :b] [:c :d] [:e :f]])))

(deftest test3 (is (= (part-flatten '((1 2)((3 4)((((5 6))))))) '((1 2)(3 4)(5 6)))))

(run-tests 'seqs.task93)