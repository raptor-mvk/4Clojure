; Topic: set theory

(ns
  ^{:author "raptor_MVK"}
  set.task84
  (:use clojure.test))

(defn transitive-closure
  "Given a set of 2 item vectors, representing a binary relation, returns its
  transitive closure"
  [relation]
  (let [update (fn [x coll] (map #(vector (first %) (last x))
                              (filter #(= (last %) (first x)) coll)))
        new-relation (reduce into relation (map #(update % relation) relation))]
    (if (= new-relation relation)
      new-relation
      (transitive-closure new-relation))))

(deftest test1 (is (let [divides #{[8 4] [9 3] [4 2] [27 9]}]
                     (= (transitive-closure divides)
                         #{[4 2] [8 4] [8 2] [9 3] [27 9] [27 3]}))))

(deftest test2 (is (let [more-legs #{["cat" "man"] ["man" "snake"] ["spider" "cat"]}]
                     (= (transitive-closure more-legs)
                         #{["cat" "man"] ["cat" "snake"] ["man" "snake"]
                           ["spider" "cat"] ["spider" "man"] ["spider" "snake"]}))))

(deftest test3 (is (let [progeny #{["father" "son"] ["uncle" "cousin"]
                                   ["son" "grandson"]}]
                     (= (transitive-closure progeny)
                         #{["father" "son"] ["father" "grandson"] ["uncle" "cousin"]
                           ["son" "grandson"]}))))

(run-tests 'set.task84)