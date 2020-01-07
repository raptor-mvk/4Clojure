; Topic: miscellaneous

(ns
  ^{:author "raptor_MVK"}
  misc.task138
  (:use clojure.test))

(defn squares-spiral
  "Given the start and the end, returns a vector of strings which renders a 45° rotated square of integers which are
  successive squares from the start point up to and including the end point. Numbers with multiple digits wrap around
  the shape digit by digit, if there are not enough digits, the shape should be finished with asterisk characters.
  The direction of the drawing should be clockwise, starting from the center of the shape and working outwards,
  with the initial direction being down and to the right"
  [start finish]
  (let [seq (take-while #(<= % finish) (iterate #(* % %) start))
        seq-str (reduce str "" seq)
        seq-str-length (count seq-str)
        squares-seq (map #(* % %) (range))
        square-edge-len (some #(and (>= % seq-str-length) %) squares-seq)
        seq-for-square (reduce str seq-str (repeat (- square-edge-len seq-str-length) \*))
        spiral-func (fn spiral-func [start-pos n] (let [x (first start-pos)
                                                        y (last start-pos)]
                                                    (lazy-cat (repeat n start-pos) (repeat n [(- x) y])
                                                              (spiral-func [(- x) (- y)] (inc n)))))
        pl (fn put-digit [res digit pos] (let [x (first pos)
                                               y (last pos)
                                               m (count res)
                                               n (count (first res))
                                               spaces (vec (repeat n " "))]
                                           (cond
                                             (< y 0) (put-digit (into [spaces] res) digit [x (inc y)])
                                             (>= y m) (put-digit (into res [spaces]) digit pos)
                                             (< x 0) (put-digit (vec (map #(into [" "] %) res)) digit [(inc x) y])
                                             (>= x n) (put-digit (vec (map #(into % [" "]) res)) digit [x y])
                                             :else (assoc-in res [y x] digit))))]
    (if (= square-edge-len 1)
      [seq-str]
      (map #(apply str %)
           (loop [positions (take (dec square-edge-len) (spiral-func [1 1] 1))
                  cur-pos [0 0]
                  cur-seq (rest seq-for-square)
                  res [[(first seq-for-square)]]]
             (if (empty? cur-seq)
               res
               (let [changed-pos (map + cur-pos (first positions))
                     new-pos [(max 0 (first changed-pos)) (max 0 (last changed-pos))]]
                 (recur (rest positions) new-pos (rest cur-seq) (pl res (first cur-seq) changed-pos)))))))))

(deftest test1 (is (= (squares-spiral 2 2) ["2"])))

(deftest test2 (is (= (squares-spiral 2 4)
                      [" 2 "
                       "* 4"
                       " * "])))

(deftest test3 (is (= (squares-spiral 3 81)
                      [" 3 "
                       "1 9"
                       " 8 "])))

(deftest test4 (is (= (squares-spiral 4 20)
                      [" 4 "
                       "* 1"
                       " 6 "])))

(deftest test5 (is (= (squares-spiral 2 256)
                      ["  6  "
                       " 5 * "
                       "2 2 *"
                       " 6 4 "
                       "  1  "])))

(deftest test6 (is (= (squares-spiral 10 10000)
                      ["   0   "
                       "  1 0  "
                       " 0 1 0 "
                       "* 0 0 0"
                       " * 1 * "
                       "  * *  "
                       "   *   "])))

(run-tests 'misc.task138)