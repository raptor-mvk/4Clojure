; Topic: games

(ns
  ^{:author "raptor_MVK"}
  games.task141
  (:use clojure.test))

(defn make-trick-winner-func
  "Given a trump suit, and returns a function that determines trick winner. It will be called on a sequence of cards,
  and should return the one which wins the trick"
  [trump]
  (fn
    [coll]
    (let [trump (filter #(= (:suit %) trump) coll)
          lead (filter #(= (:suit %) (:suit (first coll))) coll)]
      (if (empty? trump)
        (last (sort-by :rank lead))
        (last (sort-by :rank trump))))))

(deftest test1 (is (let [notrump (make-trick-winner-func nil)]
                     (and (= {:suit :club :rank 9} (notrump [{:suit :club :rank 4}
                                                             {:suit :club :rank 9}]))
                          (= {:suit :spade :rank 2} (notrump [{:suit :spade :rank 2}
                                                              {:suit :club :rank 10}]))))))

(deftest test2 (is (= {:suit :club :rank 10} ((make-trick-winner-func :club) [{:suit :spade :rank 2}
                                                                              {:suit :club :rank 10}]))))

(deftest test3 (is (= {:suit :heart :rank 8}
                      ((make-trick-winner-func :heart) [{:suit :heart :rank 6} {:suit :heart :rank 8}
                                                        {:suit :diamond :rank 10} {:suit :heart :rank 4}]))))

(run-tests 'games.task141)