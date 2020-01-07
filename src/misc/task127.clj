; Topic: miscellaneous

(ns
  ^{:author "raptor_MVK"}
  misc.task127
  (:use clojure.test))

(defn get-triangular-area
  "Given a collection of integers, each integer when read in base-2 gives the bit-representation of the rock (1s are
  mineral and 0s are worthless scalene-like rock), returns the cross-sectional triangular area of the largest
  harvestable mineral from the input rock"
  [coll]
  (let [m (int (Math/ceil (/ (Math/log (apply max coll)) (Math/log 2))))
        n (count coll)
        convert-board (fn convert-board
                        [x n]
                        (if (= n 0)
                          []
                          (concat (convert-board (quot x 2) (dec n)) [(mod x 2)])))
        board (map #(convert-board % m) coll)
        get-last-reversed (fn [c] (reverse (map last c)))
        rotate (fn [board n] (map #(get-last-reversed (last %))
                                  (group-by #(- n (mod (first %) n))
                                            (map-indexed vector (flatten board)))))
        max-edge-length-to-point (fn [seq] (reductions #(if (= 0 %2) 0 (+ %1 %2)) seq))
        convert-to-diagonal-edge-length (fn [seq] (map #(quot (inc %) 2) seq))
        board2 (rotate board m)
        board3 (rotate board2 n)
        board4 (rotate board3 m)
        update-cur-line (fn [prev-line cur-line] (map #(if (> %2 %1) (inc %1) %2) prev-line cur-line))
        update-right-angled-prev-line (fn [prev-line rest-lines] (update-cur-line prev-line (first rest-lines)))
        update-isosceles-prev-line (fn [prev-line cur-line]
                                     (update-cur-line (concat [0] (butlast prev-line)) (first cur-line)))
        update-rest-board-for-right-angled (fn [board] (map max-edge-length-to-point (rest board)))
        update-rest-board-for-isosceles (fn [board]
                                          (map #(convert-to-diagonal-edge-length (max-edge-length-to-point %))
                                               (rest board)))
        calc-triangle-edge-length (fn [board update-line update-rest-board]
                                    (apply max (flatten (loop [prev-line (first board)
                                                               cur-board (update-rest-board board)
                                                               res [prev-line]]
                                                          (if (empty? cur-board)
                                                            res
                                                            (let [new-prev-line (update-line prev-line cur-board)]
                                                              (recur new-prev-line
                                                                     (rest cur-board)
                                                                     (concat res [new-prev-line]))))))))
        right-angled-triangle-edge-length (apply max
                                                 (map #(calc-triangle-edge-length %
                                                                                  update-right-angled-prev-line
                                                                                  update-rest-board-for-right-angled)
                                                      [board board2 board3 board4]))
        isosceles-triangle-edge-half-length (apply max
                                                   (map #(calc-triangle-edge-length %
                                                                                    update-isosceles-prev-line
                                                                                    update-rest-board-for-isosceles)
                                                        [board board2 board3 board4]))
        right-angled-triangle-area (quot (* (inc right-angled-triangle-edge-length) right-angled-triangle-edge-length)
                                         2)
        isosceles-triangle-area (* isosceles-triangle-edge-half-length isosceles-triangle-edge-half-length)
        result (max right-angled-triangle-area isosceles-triangle-area)]
    (if (= result 1) nil result)))

(deftest test1 (is (= 10 (get-triangular-area [15 15 15 15 15]))))
; 1111      1111
; 1111      *111
; 1111  ->  **11
; 1111      ***1
; 1111      ****

(deftest test2 (is (= 15 (get-triangular-area [1 3 7 15 31]))))
; 00001      0000*
; 00011      000**
; 00111  ->  00***
; 01111      0****
; 11111      *****

(deftest test3 (is (= 3 (get-triangular-area [3 3]))))
; 11      *1
; 11  ->  **

(deftest test4 (is (= 4 (get-triangular-area [7 3]))))
; 111      ***
; 011  ->  0*1

(deftest test5 (is (= 6 (get-triangular-area [17 22 6 14 22]))))
; 10001      10001
; 10110      101*0
; 00110  ->  00**0
; 01110      0***0
; 10110      10110

(deftest test6 (is (= 9 (get-triangular-area [18 7 14 14 6 3]))))
; 10010      10010
; 00111      001*0
; 01110      01**0
; 01110  ->  0***0
; 00110      00**0
; 00011      000*1

(deftest test7 (is (= nil (get-triangular-area [21 10 21 10]))))
; 10101      10101
; 01010      01010
; 10101  ->  10101
; 01010      01010

(deftest test8 (is (= nil (get-triangular-area [0 31 0 31 0]))))
; 00000      00000
; 11111      11111
; 00000  ->  00000
; 11111      11111
; 00000      00000

(run-tests 'misc.task127)