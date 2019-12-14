; Topic: games

(ns
  ^{:author "raptor_MVK"}
  games.task94
  (:use clojure.test))

(defn life-move
  "Given a game of life board representation, returns board after next generation"
  [board]
  (let [lines (count (first board))
        zeroes (list (repeat lines 0))
        parse-board (fn [s] (map #(if (= % \#) 1 0) s))
        present-board (fn [c] (apply str (map #(if (= % 1) \# " ") c)))
        parsed-board (map parse-board board)
        shift-left (fn [c] (concat (rest c) '(0)))
        shift-right (fn [c] (concat '(0) (butlast c)))
        board-moved-left (map shift-left parsed-board)
        board-moved-right (map shift-right parsed-board)
        board-moved-up (concat (rest parsed-board) zeroes)
        board-moved-down (concat zeroes (butlast parsed-board))
        board-moved-up-left (concat (rest board-moved-left) zeroes)
        board-moved-down-left (concat zeroes (butlast board-moved-left))
        board-moved-up-right (concat (rest board-moved-right) zeroes)
        board-moved-down-right (concat zeroes (butlast board-moved-right))
        neighbors-count (map #(map + %1 %2 %3 %4 %5 %6 %7 %8)
                             board-moved-left
                             board-moved-right
                             board-moved-up
                             board-moved-down
                             board-moved-up-left
                             board-moved-down-left
                             board-moved-down-right
                             board-moved-up-right)
        move (fn [state neighbors] (cond
                       (and (= state 0) (= neighbors 3)) 1
                       (and (= state 1) (or (< neighbors 2) (> neighbors 3))) 0
                       :else state))
        board-after-move (map #(map move %1 %2) parsed-board neighbors-count)]
    (map present-board board-after-move)))

(deftest test1 (is (= (life-move
                        ["      "
                         " ##   "
                         " ##   "
                         "   ## "
                         "   ## "
                         "      "])
                      ["      "
                       " ##   "
                       " #    "
                       "    # "
                       "   ## "
                       "      "])))

(deftest test2 (is (= (life-move
                        ["     "
                         "     "
                         " ### "
                         "     "
                         "     "])
                      ["     "
                       "  #  "
                       "  #  "
                       "  #  "
                       "     "])))

(deftest test3 (is (= (life-move
                        ["      "
                         "      "
                         "  ### "
                         " ###  "
                         "      "
                         "      "])
                      ["      "
                       "   #  "
                       " #  # "
                       " #  # "
                       "  #   "
                       "      "])))

(run-tests 'games.task94)