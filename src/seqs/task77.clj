; Topic: sequences

(ns
  ^{:author raptor_MVK}
  seqs.task77
  (:use clojure.test))

(defn anagrams
  "Given a vector of words, returns set of sets, each sub-set consists of words,
  whiche are anagrams to each other"
  [coll]
  (into #{} (map #(into #{} %)
              (filter #(> (count %) 1) (map last (group-by sort coll))))))

(deftest test1 (is (= (anagrams ["meat" "mat" "team" "mate" "eat"])
                       #{#{"meat" "team" "mate"}})))

(deftest test2 (is (= (anagrams ["veer" "lake" "item" "kale" "mite" "ever"])
                       #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})))

(run-tests 'seqs.task77)