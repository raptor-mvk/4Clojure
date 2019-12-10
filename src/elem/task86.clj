; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task86
  (:use clojure.test))

(defn happy?
  "Given a number, returns true, if iterative process of taking each individual digit,
  squaring it, and then summing the squares to get a new number, converges to 1, and
  false otherwise"
  [n]
  (let [ch2int #(- (int %) (int \0))
        sqr #(* % %)
        sqri (fn [x] (reduce + (map #(sqr (ch2int %)) (str x))))]
    (loop [res []
           cur n]
      (if (= 1 cur)
        true
        (if (nil? (some #{cur} res))
          (recur (conj res cur) (sqri cur))
          false)))))

(deftest test1 (is (= (happy? 7) true)))

(deftest test2 (is (= (happy? 986543210) true)))

(deftest test3 (is (= (happy? 2) false)))

(deftest test4 (is (= (happy? 3) false)))

(run-tests 'elem.task86)