; Topic: miscellaneous

(ns
  ^{:author "raptor_MVK"}
  misc.task113
  (:use clojure.test))

(defn get-unique-params
  "Given a variable number of integer arguments. If the output is coerced into a string, returns a comma (and space)
  separated list of the inputs sorted smallest to largest. If the output is coerced into a sequence, returns a seq of
  unique input elements in the same order as they were entered."
  [& coll]
  (reify clojure.lang.Seqable
    (toString [this] (clojure.string/join ", " (sort coll)))
    (seq [this] (if (empty? coll) nil (distinct coll)))))

(deftest test1 (is (= "1, 2, 3" (str (get-unique-params 2 1 3)))))

(deftest test2 (is (= '(2 1 3) (seq (get-unique-params 2 1 3)))))

(deftest test3 (is (= '(2 1 3) (seq (get-unique-params 2 1 3 3 1 2)))))

(deftest test4 (is (= '(1) (seq (apply get-unique-params (repeat 5 1))))))

(deftest test5 (is (= "1, 1, 1, 1, 1" (str (apply get-unique-params (repeat 5 1))))))

(deftest test6 (is (and (= nil (seq (get-unique-params))) (=  "" (str (get-unique-params))))))

(run-tests 'misc.task113)