; Topic: graph
; Idea: breadth-first search

(ns
  ^{:author "raptor_MVK"}
  graph.task91
  (:use clojure.test))

(defn connected?
  "Given a graph, determine whether the graph is connected"
  [graph]
  (let [vertices (set (flatten (reduce conj '() graph)))
        get-edge-ends (fn [get-edge-end-func graph vertices] (filter #(= (get-edge-end-func %) vertices) graph))
        start (first vertices)]
    (loop [current [start]
           result #{start}]
      (let [new-vertices (reduce into (reduce into #{} (map #(map last (get-edge-ends first graph %)) current))
                      (map #(map first (get-edge-ends last graph %)) current))
            new-result (into result new-vertices)]
        (condp = new-result
          vertices true
          result false
          (recur new-vertices new-result))))))

(deftest test1 (is (= true (connected? #{[:a :a]}))))

(deftest test2 (is (= true (connected? #{[:a :b]}))))

(deftest test3 (is (= false (connected? #{[1 2] [2 3] [3 1] [4 5] [5 6] [6 4]}))))

(deftest test4 (is (= true (connected? #{[1 2] [2 3] [3 1] [4 5] [5 6] [6 4] [3 4]}))))

(deftest test5 (is (= false (connected? #{[:a :b] [:b :c] [:c :d] [:x :y] [:d :a] [:b :e]}))))

(deftest test6 (is (= true (connected? #{[:a :b] [:b :c] [:c :d] [:x :y] [:d :a] [:b :e] [:x :a]}))))

(run-tests 'graph.task91)