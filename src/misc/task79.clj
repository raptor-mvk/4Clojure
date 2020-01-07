; Topic: miscellaneous

(ns
  ^{:author "raptor_MVK"}
  misc.task79
  (:use clojure.test))

(defn min-path
  "Given a triangle, represented as a collection of vectors, returns the sum of
  the minimal path through a triangle, that starts at the top of the triangle and move
  to an adjacent number on the next row until the bottom of the triangle is reached"
  [t]
  (let [paths (fn [i b t] (+ (nth t i) (min (nth b i) (nth b (inc i)))))]
    (loop [prev (last t)
           cur (butlast t)]
      (if (empty? cur)
        (first prev)
        (recur (map #(paths % prev (last cur)) (range (dec (count prev)))) (butlast cur))
        ))))


(deftest test1 (is (= 7 (min-path '([1]
                                    [2 4]
                                    [5 1 4]
                                    [2 3 4 5])))))

(deftest test2 (is (= 20 (min-path '([3]
                                     [2 4]
                                     [1 9 3]
                                     [9 9 2 4]
                                     [4 6 6 7 8]
                                     [5 7 3 5 1 4])))))

(run-tests 'misc.task79)