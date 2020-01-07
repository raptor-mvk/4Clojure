; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task146
  (:use clojure.test))

(defn flatten-1-level
  "Given a map of hashmaps, returns the map that flattened by one level"
  [seq]
  (let [up (fn [key value] (if (map? value)
                         (map #(hash-map (vector key (first %)) (last %)) value)
                         (hash-map key value)))]
    (reduce into {} (map #(up (key %) (val %)) seq))))

(deftest test1 (is (= (flatten-1-level '{a {p 1, q 2} b {m 3, n 4}}) '{[a p] 1, [a q] 2 [b m] 3, [b n] 4})))

(deftest test2 (is (= (flatten-1-level '{[1] {a b c d} [2] {q r s t u v w x}})
                      '{[[1] a] b, [[1] c] d, [[2] q] r, [[2] s] t, [[2] u] v, [[2] w] x})))

(deftest test3 (is (= (flatten-1-level '{m {1 [a b c] 3 nil}}) '{[m 1] [a b c], [m 3] nil})))

(run-tests 'seqs.task146)