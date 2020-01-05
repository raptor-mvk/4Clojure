; Topic: math

(ns
  ^{:author "raptor_MVK"}
  math.task115
  (:use clojure.test))

(defn balanced?
  "Given an integer n, returns true if its component digits have the same sum on the left and right halves of the number
  and false otherwise"
  [n]
  (let [str-number (str n)
        half-length (int (/ (count str-number) 2))
        left-half (take half-length str-number)
        right-half (take half-length (reverse str-number))
        sum (fn [seq] (reduce #(+ (int %2) %1) 0 seq))]
    (= (sum left-half) (sum right-half))))

(deftest test1 (is (= true (balanced? 11))))

(deftest test2 (is (= true (balanced? 121))))

(deftest test3 (is (= false (balanced? 123))))

(deftest test4 (is (= true (balanced? 0))))

(deftest test5 (is (= false (balanced? 88099))))

(deftest test6 (is (= true (balanced? 89098))))

(deftest test7 (is (= true (balanced? 89089))))

(deftest test8 (is (= (take 20 (filter balanced? (range))) [0 1 2 3 4 5 6 7 8 9 11 22 33 44 55 66 77 88 99 101])))

(run-tests 'math.task115)