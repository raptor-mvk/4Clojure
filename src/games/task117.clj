; Topic: games

(ns
  ^{:author "raptor_MVK"}
  games.task117
  (:use clojure.test))

(defn solvable?
  "Given a maze in the form of a collection of rows, each row is a string, returns true if the maze is solvable by the
  mouse and false otherwise"
  [board]
  (let [normalize-board (fn [s] (map #(condp = % \# -1 \M 0 \C -3 0) s))
        board-normalized (map normalize-board board)
        max-x (dec (count (first board)))
        max-y (dec (count board))
        mouse-pos (map #(.indexOf % "M") board)
        start-x (apply max mouse-pos)
        start-y (.indexOf mouse-pos start-x)]
    (loop [queue [[start-x start-y]]
           was #{}]
      (if (empty? queue)
        false
        (let [cur (first queue)
              cur-x (first cur)
              cur-y (last cur)
              cur-value (nth (nth board-normalized cur-y) cur-x)
              was-not? #(when-not (some #{%} was) %)
              move-left (when (> cur-x 0) [(dec cur-x) cur-y])
              move-right (when (< cur-x max-x) [(inc cur-x) cur-y])
              move-up (when (> cur-y 0) [cur-x (dec cur-y)])
              move-down (when (< cur-y max-y) [cur-x (inc cur-y)])
              new-queue-items (reduce conj [] (filter #(not (nil? %))
                                                      (map was-not? (vector move-left move-right move-up move-down))))]
          (condp = cur-value
            -3 true
            0 (recur (concat (rest queue) new-queue-items) (conj was cur))
            (recur (rest queue) was)))))))

(deftest test1 (is (= true (solvable? ["M   C"]))))

(deftest test2 (is (= false (solvable? ["M # C"]))))

(deftest test3 (is (= true (solvable?
                             ["#######"
                              "#     #"
                              "#  #  #"
                              "#M # C#"
                              "#######"]))))

(deftest test4 (is (= false (solvable?
                              ["########"
                               "#M  #  #"
                               "#   #  #"
                               "# # #  #"
                               "#   #  #"
                               "#  #   #"
                               "#  # # #"
                               "#  #   #"
                               "#  #  C#"
                               "########"]))))

(deftest test5 (is (= false (solvable?
                              ["M     "
                               "      "
                               "      "
                               "      "
                               "    ##"
                               "    #C"]))))

(deftest test6 (is (= true (solvable?
                             ["C######"
                              " #     "
                              " #   # "
                              " #   #M"
                              "     # "]))))

(deftest test7 (is (= true (solvable?
                             ["C# # # #"
                              "        "
                              "# # # # "
                              "        "
                              " # # # #"
                              "        "
                              "# # # #M"]))))

(run-tests 'games.task117)