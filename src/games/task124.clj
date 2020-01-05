; Topic: games

(ns
  ^{:author "raptor_MVK"}
  games.task124
  (:use clojure.test))

(defn get-correct-moves
  "Given a game board and color, returns a map of legal moves for that color. Each key should be the coordinates of a
  legal move, and its value a set of the coordinates of the pieces flipped by that move"
  [board player]
  (let [opponent (if (= player 'w) 'b 'w)
        get-cell-state #(get-in board [%1 %2])
        get-flipped-piece-coord (fn [move-coord opposite-cell-coord coeff]
                                  (int (+ move-coord (* (- opposite-cell-coord move-coord) coeff))))
        get-flipped-pieces (fn [move opposite-cell full-line?]
                             (let [move-x (first move)
                                   move-y (last move)
                                   opposite-cell-x (first opposite-cell)
                                   opposite-cell-y (last opposite-cell)
                                   internal-cell (if full-line? 1/3 1/2)
                                   flipped-cell-x (get-flipped-piece-coord move-x opposite-cell-x internal-cell)
                                   flipped-cell-y (get-flipped-piece-coord move-y opposite-cell-y internal-cell)
                                   flipped-cell-state (get-cell-state flipped-cell-x flipped-cell-y)
                                   flipped-cell2-x (get-flipped-piece-coord move-x opposite-cell-x 2/3)
                                   flipped-cell2-y (get-flipped-piece-coord move-y opposite-cell-y 2/3)
                                   flipped-cell2-state (get-cell-state flipped-cell2-x flipped-cell2-y)
                                   opposite-cell-state (get-cell-state opposite-cell-x opposite-cell-y)]
                               {[move-x move-y]
                                (if (= (get-cell-state move-x move-y) 'e)
                                  (cond
                                    (and full-line?
                                         (= flipped-cell-state opponent)
                                         (= flipped-cell2-state player)) #{[flipped-cell-x flipped-cell-y]}
                                    (and (not full-line?)
                                         (= flipped-cell-state opponent)
                                         (= opposite-cell-state player)) #{[flipped-cell-x flipped-cell-y]}
                                    (and full-line?
                                         (= flipped-cell-state opponent)
                                         (= flipped-cell2-state opponent)
                                         (= opposite-cell-state player))
                                    #{[flipped-cell-x flipped-cell-y] [flipped-cell2-x flipped-cell2-y]}
                                    :else #{})
                                  #{})}))
        get-possible-moves (fn [move opposite-cells-map] (reduce #(merge-with into %1 %2) {}
                                                                 (map #(get-flipped-pieces move (first %) (last %))
                                                                      opposite-cells-map)))
        possible-moves-map #{[[0 0] [[[0 3] true] [[3 0] true] [[3 3] true]]]
                             [[0 1] [[[0 3] false] [[3 1] true] [[2 3] false]]]
                             [[0 2] [[[0 0] false] [[3 2] true] [[2 0] false]]]
                             [[0 3] [[[0 0] true] [[3 3] true] [[3 0] true]]]
                             [[1 3] [[[1 0] true] [[3 3] false] [[3 1] false]]]
                             [[2 3] [[[2 0] true] [[0 3] false] [[0 1] false]]]
                             [[3 3] [[[0 3] true] [[3 0] true] [[0 0] true]]]
                             [[3 2] [[[3 0] false] [[0 2] true] [[1 0] false]]]
                             [[3 1] [[[3 3] false] [[0 1] true] [[1 3] false]]]
                             [[3 0] [[[0 0] true] [[3 3] true] [[0 3] true]]]
                             [[2 0] [[[0 0] false] [[2 3] true] [[0 2] false]]]
                             [[1 0] [[[3 0] false] [[1 3] true] [[3 2] false]]]}]
    (reduce into (filter #(not (empty? (first (vals %))))
                         (map #(get-possible-moves (first %) (last %)) possible-moves-map)))))

(deftest test1 (is (= {[1 3] #{[1 2]}, [0 2] #{[1 2]}, [3 1] #{[2 1]}, [2 0] #{[2 1]}}
                      (get-correct-moves
                        '[[e e e e]
                          [e w b e]
                          [e b w e]
                          [e e e e]]
                        'w))))

(deftest test2 (is (= {[3 2] #{[2 2]}, [3 0] #{[2 1]}, [1 0] #{[1 1]}}
                      (get-correct-moves
                        '[[e e e e]
                          [e w b e]
                          [w w w e]
                          [e e e e]]
                        'b))))

(deftest test3 (is (= {[0 3] #{[1 2]}, [1 3] #{[1 2]}, [3 3] #{[2 2]}, [2 3] #{[2 2]}}
                      (get-correct-moves
                        '[[e e e e]
                          [e w b e]
                          [w w b e]
                          [e e b e]]
                        'w))))

(deftest test4 (is (= {[0 3] #{[2 1] [1 2]}, [1 3] #{[1 2]}, [2 3] #{[2 1] [2 2]}}
                      (get-correct-moves
                        '[[e e w e]
                          [b b w e]
                          [b w w e]
                          [b w w w]]
                        'b))))

(run-tests 'games.task124)