; Topic: graph

(ns
  ^{:author "raptor_MVK"}
  graph.task130
  (:use clojure.test))

(defn get-tree-with-new-root
  "Given the name of the node that should become the new root, and the tree to transform, returns transformed tree"
  [new-root tree]
  (let [find-root (fn find-root
                    [tree]
                    (if (= new-root (first tree))
                      true
                      (if (< 1 (count tree))
                        (reduce #(or %1 %2) (map find-root (rest tree)))
                        false)))
        transform-tree (fn transform-tree
                         [tree]
                         (let [cur-root (first tree)]
                           (if (= new-root cur-root)
                             tree
                             (let [tree-without-root (rest tree)
                                   new-root-index (.indexOf (map find-root tree-without-root) true)
                                   tree-without-new-root (concat (take new-root-index tree-without-root)
                                                                 (drop (inc new-root-index) tree-without-root))]
                               (transform-tree (concat (nth tree-without-root new-root-index)
                                                       (list (conj tree-without-new-root cur-root))))))))]
    (if (= new-root (first tree))
      tree
      (transform-tree tree))))

(deftest test1 (is (= '(n) (get-tree-with-new-root 'n '(n)))))

(deftest test2 (is (= '(a (t (e))) (get-tree-with-new-root 'a '(t (e) (a))))))

(deftest test3 (is (= '(e (t (a))) (get-tree-with-new-root 'e '(a (t (e)))))))

(deftest test4 (is (= '(a (b (c))) (get-tree-with-new-root 'a '(c (b (a)))))))

(deftest test5 (is (= '(d (b (c) (e) (a (f (g) (h))))) (get-tree-with-new-root 'd '(a (b (c) (d) (e)) (f (g) (h)))))))

(deftest test6 (is (= '(c (d) (e) (b (f (g) (h)) (a (i (j (k) (l)) (m (n) (o))))))
                      (get-tree-with-new-root 'c '(a (b (c (d) (e)) (f (g) (h))) (i (j (k) (l)) (m (n) (o))))))))

(run-tests 'graph.task130)