; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  rec.task68
  (:use clojure.test))

(def value
  "Define value that satisfies the given test condition"
  '(7 6 5 4 3))

(deftest test1 (is (= value
                      (loop [x 5
                             result []]
                        (if (> x 0)
                          (recur (dec x) (conj result (+ 2 x)))
                          result)))))

(run-tests 'rec.task68)