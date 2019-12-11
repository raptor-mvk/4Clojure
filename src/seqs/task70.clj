; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task70
  (:use clojure.test))

(defn sort-words
  "Given a string, returs a sorted (case ignored) list of words"
  [s]
  (sort #(.compareToIgnoreCase %1 %2) (clojure.string/split s #"[ ,\\.!?-]")))

(deftest test1 (is (= (sort-words "Have a nice day.") ["a" "day" "Have" "nice"])))

(deftest test2 (is (= (sort-words "Clojure is a fun language!")
                      ["a" "Clojure" "fun" "is" "language"])))

(deftest test3 (is (= (sort-words "Fools fall for foolish follies.")
                      ["fall" "follies" "foolish" "Fools" "for"])))

(run-tests 'seqs.task70)