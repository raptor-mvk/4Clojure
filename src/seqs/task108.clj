; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task108
  (:use clojure.test))

(defn find-common-min
  "Given any number of sequences, each sorted from smallest to largest, find the smallest single number which appears
  in all of the sequences"
  [& coll]
  (if-not (coll? (first coll))
    (first coll)
    (loop [cur-coll coll
           cur-number (first (first coll))]
      (let [first-items (map first cur-coll)
            cur-max (apply max first-items)]
        (if (every? #(= cur-number %) first-items)
          cur-number
          (let [remove-head (fn [x] (drop-while #(< % cur-max) x))]
            (recur (map remove-head coll) cur-max)))))))

(deftest test1 (is (= 3 (find-common-min [3 4 5]))))

(deftest test2 (is (= 4 (find-common-min [1 2 3 4 5 6 7] [0.5 3/2 4 19]))))

(deftest test3 (is (= 7 (find-common-min (range) (range 0 100 7/6) [2 3 5 7 11 13]))))

(deftest test4 (is (= 64 (find-common-min (map #(* % % %) (range)) ; perfect cubes
                                          (filter #(zero? (bit-and % (dec %))) (range)) ; powers of 2
                                          (iterate inc 20))))) ; at least as large as 20

(run-tests 'seqs.task108)