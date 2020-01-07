; Topic: miscellaneous

(ns
  ^{:author "raptor_MVK"}
  misc.task29
  (:use clojure.test))

(defn upcase-filter
  "Given a string, returns a new string containing only the capital letters"
  [s]
  (apply str (filter #(Character/isUpperCase ^Character %) s)))

(deftest test1 (is (= (upcase-filter "HeLlO, WoRlD!") "HLOWRD")))

(deftest test2 (is (empty? (upcase-filter "nothing"))))

(deftest test3 (is (= (upcase-filter "$#A(*&987Zf") "AZ")))

(run-tests 'misc.task29)