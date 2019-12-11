; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task8
  (:use clojure.test)
  (:use clojure.set))

(def result
  "Define value that satisfies the given test conditions"
  (set '(:a :b :c :d)))

(deftest test1 (is (= result (set '(:a :a :b :c :c :c :c :d :d)))))

(deftest test2 (is (= result (clojure.set/union #{:a :b :c} #{:b :c :d}))))

(run-tests 'elem.task8)