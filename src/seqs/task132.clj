; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task132
  (:use clojure.test))

(defn insert-value-between
  "Given a two-argument predicate, a value, and a collection, returns a new collection where the value is inserted
  between every two items that satisfy the predicate."
  [predicate value coll]
  (if (empty? coll)
    '()
    (let [first (first coll)
          second (second coll)]
      (if (nil? second)
        [first]
        (lazy-cat (if (predicate first second) [first value] [first]) (insert-value-between predicate value (rest coll)))))))

(deftest test1 (is (= '(1 :less 6 :less 7 4 3) (insert-value-between < :less [1 6 7 4 3]))))

(deftest test2 (is (= '(2) (insert-value-between > :more [2]))))

(deftest test3 (is (= [0 1 :x 2 :x 3 :x 4] (insert-value-between #(and (pos? %) (< % %2)) :x (range 5)))))

(deftest test4 (is (empty? (insert-value-between > :more ()))))

(deftest test5 (is (= [0 1 :same 1 2 3 :same 5 8 13 :same 21]
                      (take 12 (->> [0 1]
                                    (iterate (fn [[a b]] [b (+ a b)]))
                                    (map first)             ; fibonacci numbers
                                    (insert-value-between (fn [a b] ; both even or both odd
                                                            (= (mod a 2) (mod b 2)))
                                                          :same))))))

(run-tests 'seqs.task132)