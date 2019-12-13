; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  rec.task76
  (:use clojure.test))

(def value
  "Define value that satisfies the given test condition"
  [1 3 5 7 9 11])

(deftest test1 (is (= value
                      (letfn
                        [(foo [x y] #(bar (conj x y) y))
                         (bar [x y] (if (> (last x) 10)
                                      x
                                      #(foo x (+ 2 y))))]
                        (trampoline foo [] 1)))))

(run-tests 'rec.task76)