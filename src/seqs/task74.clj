; Topic: sequences

(ns
  ^{:author raptor_MVK}
  seqs.task74
  (:use clojure.test))

(defn filter-squares
  "Given a string of comma separated integers, returns filtered string, which consists
  of perfect squares"
  [s]
  (clojure.string/join ","
    (filter #(= 0.0 (rem (Math/sqrt %) 1))
      (map read-string (clojure.string/split s #",")))))

(deftest test1 (is (= (filter-squares "4,5,6,7,8,9") "4,9")))

(deftest test2 (is (= (filter-squares "15,16,25,36,37") "16,25,36")))

(run-tests 'seqs.task74)