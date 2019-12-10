; Topic: games

(ns
  ^{:author "raptor_MVK"}
  games.task73
  (:use clojure.test))

(defn tic-tac-toe-winner
  "Given a tic-tac-toe board representation, returns :x, if Xs are victorious, returns
  :o, if Os are victorious, otherwise returns nil"
  [board]
  (let [board-list (flatten board)
        get-elems (fn [coll] (vector (map #(nth board-list %) coll)))
        rows (apply concat [board (map #(map % board) [first second last])
                            (get-elems [0 4 8]) (get-elems [2 4 6])])
        winner (filter #(some #{:x :o} #{%}) (map first (filter #(apply = %) rows)))]
    (if (empty? winner) nil (first winner))))

(deftest test1 (is (= nil (tic-tac-toe-winner [[:e :e :e]
                                               [:e :e :e]
                                               [:e :e :e]]))))

(deftest test2 (is (= :x (tic-tac-toe-winner [[:x :e :o]
                                              [:x :e :e]
                                              [:x :e :o]]))))

(deftest test3 (is (= :o (tic-tac-toe-winner [[:e :x :e]
                                              [:o :o :o]
                                              [:x :e :x]]))))

(deftest test4 (is (= nil (tic-tac-toe-winner [[:x :e :o]
                                               [:x :x :e]
                                               [:o :x :o]]))))

(deftest test5 (is (= :x (tic-tac-toe-winner [[:x :e :e]
                                              [:o :x :e]
                                              [:o :e :x]]))))

(deftest test6 (is (= :o (tic-tac-toe-winner [[:x :e :o]
                                              [:x :o :e]
                                              [:o :e :x]]))))

(deftest test7 (is (= nil (tic-tac-toe-winner [[:x :o :x]
                                               [:x :o :x]
                                               [:o :x :o]]))))

(run-tests 'games.task73)