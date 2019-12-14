; Topic: graph

(ns
  ^{:author "raptor_MVK"}
  graph.task96
  (:use clojure.test))

(defn symmetric?
  "Given a sequence, returns true if it represents a symmetric binary tree and false otherwise"
  [root]
  (let [mirror (fn mirror [t]
                 (if (nil? t)
                   nil
                   (concat [(first t)] [(mirror (last t))] [(mirror (nth t 1))])))]
    (= root (mirror root))))

(deftest test1 (is (= true (symmetric? '(:a (:b nil nil) (:b nil nil))) true)))

(deftest test2 (is (= false (symmetric? '(:a (:b nil nil) nil)))))

(deftest test3 (is (= false (symmetric? '(:a (:b nil nil) (:c nil nil))))))

(deftest test4 (is (= true (symmetric? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                           [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]]))))

(deftest test5 (is (= false (symmetric? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                           [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]]))))

(deftest test6 (is (= false (symmetric? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                           [2 [3 nil [4 [6 nil nil] nil]] nil]]))))

(run-tests 'graph.task96)