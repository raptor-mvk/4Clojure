; Topic: graph
; Idea: deep search, vertices are words, edge (i, j) exists if j-th word
;       can be transformed from i-th word

(ns
  ^{:author "raptor_MVK"}
  graph.task82
  (:use clojure.test))

(defn word-chain?
  "Given a sequence of words, returns true if they can be arranged into one continous
  word chain (each word is created from previous with insertion, deletion or
  substitution of only one character), and false otherwise"
  [coll]
  (let [n (count coll)
        chained? (fn [a b] (let [a-length (count a)
                                 b-length (count b)
                                 test (fn [a b c]
                                        (not (nil? (some #{b}
                                                         (map #(apply str (concat (take % a)
                                                                                  (drop (inc %) a)))
                                                              (range c))))))]
                             (condp = (- a-length b-length)
                               0 (= (reduce + (map #(if (= %1 %2) 0 1) a b)) 1)
                               1 (test a b a-length)
                               -1 (test b a b-length)
                               false)))
        coll-indexed (map-indexed vector coll)
        edges (filter #(last %) (for [x coll-indexed
                                      y coll-indexed]
                                  (vector (first x) (first y)
                                          (chained? (last x) (last y)))))
        deep-search (fn deep-search [cur used]
                      (let [next-words (filter #(= cur (first %)) edges)]
                        (loop [coll next-words]
                          (if (empty? coll)
                            false
                            (if (let [next-word (second (first coll))]
                                  (if (nil? (some #{next-word} used))
                                    (if (= (inc (count used)) n)
                                      true
                                      (deep-search next-word (into used [next-word])))))
                              true
                              (recur (rest coll)))))))]
    (not (nil? (some true? (map #(deep-search % #{%}) (range (count coll))))))))

(deftest test1 (is (= true (word-chain?
                             #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"}))))

(deftest test2 (is (= false (word-chain? #{"cot" "hot" "bat" "fat"}))))

(deftest test3 (is (= false (word-chain? #{"to" "top" "stop" "tops" "toss"}))))

(deftest test4 (is (= true (word-chain? #{"spout" "do" "pot" "pout" "spot" "dot"}))))

(deftest test5 (is (= true (word-chain? #{"share" "hares" "shares" "hare" "are"}))))

(deftest test6 (is (= false (word-chain? #{"share" "hares" "hare" "are"}))))

(run-tests 'graph.task82)