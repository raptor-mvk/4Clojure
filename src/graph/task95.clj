; Topic: graph

(ns
  ^{:author "raptor_MVK"}
  graph.task95
  (:use clojure.test))

(defn tree?
  "Given a sequence, returns true if it represents a binary tree and false otherwise"
  [root]
  (if (nil? root)
    true
    (and (coll? root) (= 3 (count root)) (tree? (nth root 1)) (tree? (last root)))))

(deftest test1 (is (= true (tree? '(:a (:b nil nil) nil)))))

(deftest test2 (is (= false (tree? '(:a (:b nil nil))))))

(deftest test3 (is (= true (tree? [1 nil [2 [3 nil nil] [4 nil nil]]]))))

(deftest test4 (is (= false (tree? [1 [2 nil nil] [3 nil nil] [4 nil nil]]))))

(deftest test5 (is (= true (tree? [1 [2 [3 [4 nil nil] nil] nil] nil]))))

(deftest test6 (is (= false (tree? [1 [2 [3 [4 false nil] nil] nil] nil]))))

(deftest test7 (is (= false (tree? '(:a nil ())))))

(run-tests 'graph.task95)