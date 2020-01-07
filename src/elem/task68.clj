; Topic: recursion

(ns
  ^{:author "raptor_MVK"}
  elem.task68
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

(run-tests 'elem.task68)