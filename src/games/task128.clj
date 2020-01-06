; Topic: games

(ns
  ^{:author "raptor_MVK"}
  games.task128
  (:use clojure.test))

(defn card-convert
  "Given the string with two-character playing card identity, returns a map representation of suit and rank"
  [s]
  (hash-map :suit (get {\S :spade \H :heart \C :club \D :diamond} (first s))
            :rank (get {\2 0 \3 1 \4 2 \5 3 \6 4 \7 5 \8 6 \9 7 \T 8 \J 9 \Q 10 \K 11 \A 12}
                       (second s))))

(deftest test1 (is (= {:suit :diamond :rank 10} (card-convert "DQ"))))

(deftest test2 (is (= {:suit :heart :rank 3} (card-convert "H5"))))

(deftest test3 (is (= {:suit :club :rank 12} (card-convert "CA"))))

(deftest test4 (is (= (range 13) (map (comp :rank card-convert str) '[S2 S3 S4 S5 S6 S7 S8 S9 ST SJ SQ SK SA]))))

(run-tests 'games.task128)