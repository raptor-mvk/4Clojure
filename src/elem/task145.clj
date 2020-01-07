; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task145
  (:use clojure.test))

(def value
  "Define value that satisfies the given test conditions"
  (filter #(= (rem % 4) 1) (range 40)))

(deftest test1 (is (= value (for [x (range 40)
                                  :when (= 1 (rem x 4))]
                              x))))

(deftest test2 (is (= value (for [x (iterate #(+ 4 %) 0)
                                  :let [z (inc x)]
                                  :while (< z 40)]
                              z))))

(deftest test3 (is (= value (for [[x y] (partition 2 (range 20))]
                              (+ x y)))))

(run-tests 'elem.task145)