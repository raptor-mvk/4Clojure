; Topic: core functions

(ns
  ^{:author "raptor_MVK"}
  core.task121
  (:use clojure.test))

(defn func-eval
  "Given a mathematical formula in prefix notation, returns a function that calculates the value of the formula"
  [coll]
  (fn [variables-map]
    (cond
      (number? coll) coll
      (symbol? coll) (get variables-map coll)
      :else (apply (condp = (first coll) '/ / '* * '+ + '- -)
                   (map #((func-eval %) variables-map) (rest coll))))))

(deftest test1 (is (= 2 ((func-eval '(/ a b)) '{b 8 a 16}))))

(deftest test2 (is (= 8 ((func-eval '(+ a b 2)) '{a 2 b 4}))))

(deftest test3 (is (= [6 0 -4] (map (func-eval '(* (+ 2 a) (- 10 b))) '[{a 1 b 8} {b 5 a -2} {a 2 b 11}]))))

(deftest test4 (is (= 1 ((func-eval '(/ (+ x 2) (* 3 (+ y 1)))) '{x 4 y 1}))))

(run-tests 'core.task121)