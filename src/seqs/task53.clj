; Topic: sequences

(ns
  ^{:author raptor_MVK}
  seqs.task53
  (:use clojure.test))

(defn max-inc-subseq
  "Given a sequence, returns first longest increasing sub-sequence"
  [coll]
  (let [pairs (map vector coll (rest coll))
        mono-pairs (partition-by #(< (first %) (last %)) pairs)
        sequencer (fn [c] (reduce #(concat %1 [(last %2)]) (first c) (rest c)))
        answer (filter #(< (first %) (last %)) (map sequencer mono-pairs))]
    (if (empty? answer) '() (apply max-key count (reverse answer)))))

(deftest test1 (is (= (max-inc-subseq [1 0 1 2 3 0 4 5]) [0 1 2 3])))

(deftest test2 (is (= (max-inc-subseq [5 6 1 3 2 7]) [5 6])))

(deftest test3 (is (= (max-inc-subseq [2 3 3 4 5]) [3 4 5])))

(deftest test4 (is (= (max-inc-subseq [7 6 5 4]) [])))

(run-tests 'seqs.task53)