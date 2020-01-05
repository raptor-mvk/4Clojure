; Topic: games

(ns
  ^{:author "raptor_MVK"}
  games.task119
  (:use clojure.test))

(defn get-winning-moves
  "Given a game piece and a tic-tac-toe board representation, returns a set of all valid board placements of the game
  piece which would result in an immediate win"
  [piece board]
  (let [win-move? (fn [move]
                    (let [board-after-move (assoc-in board move piece)
                          flattened-board-after-move (flatten board-after-move)
                          rows (into board-after-move [(map first board-after-move) (map #(nth % 1) board-after-move)
                                                       (map last board-after-move)
                                                       [(first flattened-board-after-move)
                                                        (nth flattened-board-after-move 4)
                                                        (last flattened-board-after-move)]
                                                       [(nth flattened-board-after-move 2)
                                                        (nth flattened-board-after-move 4)
                                                        (nth flattened-board-after-move 6)]])
                          row? #(= piece %)
                          win? (fn [f] (reduce #(or %1 %2) (map #(every? f %) rows)))]
                      (win? row?)))]
    (into #{} (filter #(and (= :e (get-in board %)) (win-move? %))
                      (for [x (range 3) y (range 3)] [x y])))))

(deftest test1 (is (= (get-winning-moves
                        :x
                        [[:o :e :e]
                         [:o :x :o]
                         [:x :x :e]])
                      #{[2 2] [0 1] [0 2]})))

(deftest test2 (is (= (get-winning-moves
                        :x
                        [[:x :o :o]
                         [:x :x :e]
                         [:e :o :e]])
                      #{[2 2] [1 2] [2 0]})))

(deftest test3 (is (= (get-winning-moves
                        :x
                        [[:x :e :x]
                         [:o :x :o]
                         [:e :o :e]])
                      #{[2 2] [0 1] [2 0]})))

(deftest test4 (is (= (get-winning-moves
                        :x
                        [[:x :x :o]
                         [:e :e :e]
                         [:e :e :e]])
                      #{})))

(deftest test5 (is (= (get-winning-moves
                        :o
                        [[:x :x :o]
                         [:o :e :o]
                         [:x :e :e]])
                      #{[2 2] [1 1]})))

(run-tests 'games.task119)