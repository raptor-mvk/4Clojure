; Topic: core functions

(ns
  ^{:author "raptor_MVK"}
  core.task78
  (:use clojure.test))

(defn re-trampoline
  "Reimplementation of 'trampoline'"
  [f & args]
  (loop [res (apply f args)]
    (if (fn? res)
      (recur (res))
      res)))

(deftest test1 (is (= (letfn [(triple [x] #(sub-two (* 3 x)))
                          (sub-two [x] #(stop? (- x 2)))
                          (stop? [x] (if (> x 50) x #(triple x)))]
                    (re-trampoline triple 2)) 82)))

(deftest test2 (is (= (letfn [(my-even? [x] (if (zero? x) true #(my-odd? (dec x))))
                              (my-odd? [x] (if (zero? x) false #(my-even? (dec x))))]
                        (map (partial re-trampoline my-even?) (range 6)))
                     [true false true false true false])))

(run-tests 'core.task78)