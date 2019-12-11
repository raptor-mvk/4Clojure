; Topic: set theory

(ns
  ^{:author "raptor_MVK"}
  set.task90
  (:use clojure.set)
  (:use clojure.test))

(defn carthesian-prod
  "Given two sets, returns their carthesian product"
  [x y]
  (let [prod (fn [x y] (map #(vector x %) y))]
    (reduce into #{} (map #(prod % y) x))))


(deftest test1 (is (= (carthesian-prod #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
                      #{["ace" "♠"] ["ace" "♥"] ["ace" "♦"] ["ace" "♣"]
                        ["king" "♠"] ["king" "♥"] ["king" "♦"] ["king" "♣"]
                        ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]})))

(deftest test2 (is (= (carthesian-prod #{1 2 3} #{4 5})
                      #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})))

(deftest test3 (is (= 300 (count (carthesian-prod (into #{} (range 10))
                                                  (into #{} (range 30)))))))

(run-tests 'set.task90)