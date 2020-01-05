; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task101
  (:use clojure.test))

(defn levenstein-distance
  "Given two sequences, returns Levenstein distance between them"
  [x y]
  (let [make-seqs-without-item (fn [x] (map #(concat (take % x) (drop (inc %) x)) (range (count x))))
        make-seqs-without-n-items (fn make-seqs-without-n-items [x n]
                                    (if (= n 1)
                                      (make-seqs-without-item x)
                                      (reduce into #{}
                                              (map make-seqs-without-item (make-seqs-without-n-items x (dec n))))))
        x-length (count x)
        y-length (count y)
        changes-count (fn [x y] (reduce + (map #(if (= %1 %2) 0 1) x y)))
        min-changes-count (fn [x variants] (apply min (map #(changes-count x %) variants)))]
    (cond
      (= x-length y-length) (changes-count x y)
      (< x-length y-length) (let [length-diff (- y-length x-length)
                                  y-variants (make-seqs-without-n-items y length-diff)]
                              (+ length-diff (min-changes-count x y-variants)))
      :else (let [length-diff (- x-length y-length)
                  x-variants (make-seqs-without-n-items x length-diff)]
              (+ length-diff (min-changes-count y x-variants))))))

(deftest test1 (is (= (levenstein-distance "kitten" "sitting") 3)))

(deftest test2 (is (= (levenstein-distance "closure" "clojure") (levenstein-distance "clojure" "closure") 1)))

(deftest test3 (is (= (levenstein-distance "xyx" "xyyyx") 2)))

(deftest test4 (is (= (levenstein-distance "" "123456") 6)))

(deftest test5 (is (= (levenstein-distance "Clojure" "Clojure")
                      (levenstein-distance "" "")
                      (levenstein-distance [] [])
                      0)))

(deftest test6 (is (= (levenstein-distance [1 2 3 4] [0 2 3 4 5]) 2)))

(deftest test7 (is (= (levenstein-distance '(:a :b :c :d) '(:a :d)) 2)))

(deftest test8 (is (= (levenstein-distance "ttttattttctg" "tcaaccctaccat") 10)))

(deftest test9 (is (= (levenstein-distance "gaattctaatctc" "caaacaaaaaattt") 9)))

(run-tests 'seqs.task101)