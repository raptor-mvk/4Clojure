; Topic: games

(ns
  ^{:author "raptor_MVK"}
  games.task111
  (:use clojure.test))

(defn crossword-puzzle-step
  "Given a string and a partially-filled crossword puzzle board, determines whether the input string can be legally
  placed onto the board"
  [word board]
  (let [trim-board (map #(clojure.string/replace % " " "") board)
        word-length (count word)
        board-width (count (first trim-board))
        transpose-board (fn [i] (apply str (map #(nth % i) trim-board)))
        board-transposed (map transpose-board (range board-width))
        get-words (fn [board] (flatten (map #(clojure.string/split % #"#") board)))
        find-possible-places (filter
                               #(= word-length (count %))
                               (concat (get-words trim-board) (get-words board-transposed)))
        possible? (fn [f] (reduce #(and %1 %2) (map #(or (= %2 \_) (= %1 %2)) word f)))]
    (not (nil? (some true? (map possible? find-possible-places))))))

(deftest test1 (is (= true (crossword-puzzle-step "the" ["_ # _ _ e"]))))

(deftest test2 (is (= false (crossword-puzzle-step
                              "the"
                              ["c _ _ _"
                               "d _ # e"
                               "r y _ _"]))))

(deftest test3 (is (= true (crossword-puzzle-step
                             "joy"
                             ["c _ _ _"
                              "d _ # e"
                              "r y _ _"]))))

(deftest test4 (is (= false (crossword-puzzle-step
                              "joy"
                              ["c o n j"
                               "_ _ y _"
                               "r _ _ #"]))))

(deftest test5 (is (= true (crossword-puzzle-step
                             "clojure"
                             ["_ _ _ # j o y"
                              "_ _ o _ _ _ _"
                              "_ _ f _ # _ _"]))))

(run-tests 'games.task111)