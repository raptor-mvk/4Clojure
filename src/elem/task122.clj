; Topic: elementary

(ns
  ^{:author raptor_MVK}
  elem.task122
  (:use clojure.test))

(defn binstr2num
  "Given binary string, returns its numerical value"
  [s]
  (reduce #(+ (* 2 %1) (- (int %2) (int \0))) 0 s))

(deftest test1 (is (= 0 (binstr2num "0"))))

(deftest test2 (is (= 7 (binstr2num "111"))))

(deftest test3 (is (= 8 (binstr2num "1000"))))

(deftest test4 (is (= 9 (binstr2num "1001"))))

(deftest test5 (is (= 255 (binstr2num "11111111"))))

(deftest test6 (is (= 1365 (binstr2num "10101010101"))))

(deftest test7 (is (= 65535 (binstr2num "1111111111111111"))))

(run-tests 'elem.task122)