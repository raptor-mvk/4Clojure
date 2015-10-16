; Topic: sequences

(ns
  ^{:author raptor}
  seqs.task27
  (:use clojure.test))

(defn palindrome?
  "Returns true if the given sequence is a palindrome"
  [coll]
  (= (reverse coll) (seq coll)))

(deftest test1 (is (false? (palindrome? '(1 2 3 4 5)))))

(deftest test2 (is (true? (palindrome? "racecar"))))

(deftest test3 (is (true? (palindrome? [:foo :bar :foo]))))

(deftest test4 (is (true? (palindrome? '(1 1 3 3 1 1)))))

(deftest test5 (is (false? (palindrome? '(:a :b :c)))))

(run-tests 'seqs.task27)