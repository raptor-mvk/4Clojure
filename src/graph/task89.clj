; Topic: graph
; Idea: Eulerian path exists, if and only if, the graph is connected and
;       it contains 0 (cycle) or 2 (trail) vertices of odd degree

(ns
  ^{:author raptor_MVK}
  graph.task89
  (:use clojure.test))

(defn eulerian-path?
  "Given a collection of 2 item vectors, representing a graph, returns true if it is
  possible to make a tour of the graph in which every edge is visited exactly once"
  [coll]
  (let [vert-deg (frequencies (flatten coll))
        vertices (set (map first vert-deg))
        edges (concat coll (map reverse coll))
        get-neighbors (fn [v] (map last (filter #(= (first %) v) edges)))
        eulerian? (condp = (count (filter #(odd? (last %)) vert-deg))
                    0 true
                    2 true
                    false)
        connected? (loop [visited #{(first vertices)}]
                     (let [new-visited (reduce into visited (map get-neighbors visited))]
                           (condp = new-visited
                             vertices true
                             visited false
                             (recur new-visited))))]
    (and connected? eulerian?)))

(deftest test1 (is (= true (eulerian-path? [[:a :b]]))))

(deftest test2 (is (= false (eulerian-path? [[:a :a] [:b :b]]))))

(deftest test3 (is (= false (eulerian-path? [[:a :b] [:a :b] [:a :c] [:c :a] [:a :d]
                                             [:b :d] [:c :d]]))))

(deftest test4 (is (= true (eulerian-path? [[1 2] [2 3] [3 4] [4 1]]))))

(deftest test5 (is (= true (eulerian-path? [[:a :b] [:a :c] [:c :b] [:a :e] [:b :e]
                                            [:a :d] [:b :d] [:c :e] [:d :e] [:c :f]
                                            [:d :f]]))))

(deftest test6 (is (= false (eulerian-path? [[1 2] [2 3] [2 4] [2 5]]))))

(run-tests 'graph.task89)