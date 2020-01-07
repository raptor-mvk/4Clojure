; Topic: miscellaneous

(ns
  ^{:author "raptor_MVK"}
  misc.task158
  (:use clojure.test))

(defn decurry
  "Given a curried function of unknown arity n, returns an equivalent function of n arguments."
  [func]
  (fn [& x] (reduce #(%1 %2) func x)))

(deftest test1 (is (= 10 ((decurry (fn [a]
                                     (fn [b]
                                       (fn [c]
                                         (fn [d]
                                           (+ a b c d))))))
                          1 2 3 4))))

(deftest test2 (is (= 24 ((decurry (fn [a]
                                     (fn [b]
                                       (fn [c]
                                         (fn [d]
                                           (* a b c d))))))
                          1 2 3 4))))

(deftest test3 (is (= 25 ((decurry (fn [a]
                                     (fn [b]
                                       (* a b))))
                          5 5))))

(run-tests 'misc.task158)