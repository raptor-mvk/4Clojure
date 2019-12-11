; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task6
  (:use clojure.test))

(def value
  "Define value that satisfies the given test condition using template [__]"
  [:a :b :c])

(deftest test1 (is (= value (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))))

(run-tests 'elem.task6)