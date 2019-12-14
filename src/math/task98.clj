; Topic: math

(ns
  ^{:author "raptor_MVK"}
  math.task98
  (:use clojure.test))

(defn equivalence-classes
  "Given a function and a domain D, returns equivalence classes of D with respect to f"
  [f d]
  (set (map set (vals (group-by f d)))))

(deftest test1 (is (= (equivalence-classes #(* % %) #{-2 -1 0 1 2}) #{#{0} #{1 -1} #{2 -2}})))

(deftest test2 (is (= (equivalence-classes #(rem % 3) #{0 1 2 3 4 5 }) #{#{0 3} #{1 4} #{2 5}})))

(deftest test3 (is (= (equivalence-classes identity #{0 1 2 3 4}) #{#{0} #{1} #{2} #{3} #{4}})))

(deftest test4 (is (= (equivalence-classes (constantly true) #{0 1 2 3 4}) #{#{0 1 2 3 4}})))

(run-tests 'math.task98)