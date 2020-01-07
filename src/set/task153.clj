; Topic: set theory

(ns
  ^{:author "raptor_MVK"}
  set.task153
  (:use clojure.set)
  (:use clojure.test))

(defn pairwise-disjoint?
  "Given a set of sets, returns true if no two of those sets have any elements in common and false otherwise"
  [coll]
  (reduce #(and %1 %2) (for [x coll
                             y coll]
                         (if (= x y)
                           true
                           (empty? (clojure.set/intersection x y))))))

; all sets have a subset which sums to zero
(deftest test1 (is (= (pairwise-disjoint? #{#{\U} #{\s} #{\e \R \E} #{\P \L} #{\.}}) true)))

(deftest test2 (is (= (pairwise-disjoint? #{#{:a :b :c :d :e} #{:a :b :c :d} #{:a :b :c} #{:a :b} #{:a}}) false)))

(deftest test3 (is (= (pairwise-disjoint? #{#{[1 2 3] [4 5]} #{[1 2] [3 4 5]} #{[1] [2] 3 4 5} #{1 2 [3 4] [5]}})
                      true)))

(deftest test4 (is (= (pairwise-disjoint? #{#{'a 'b} #{'c 'd 'e} #{'f 'g 'h 'i} #{''a ''c ''f}}) true)))

(deftest test5 (is (= (pairwise-disjoint? #{#{'(:x :y :z) '(:x :y) '(:z) '()}
                                            #{#{:x :y :z} #{:x :y} #{:z} #{}}
                                            #{'[:x :y :z] [:x :y] [:z] [] {}}})
                      false)))

(deftest test6 (is (= (pairwise-disjoint? #{#{(= "true") false}
                                            #{:yes :no}
                                            #{(class 1) 0}
                                            #{(symbol "true") 'false}
                                            #{(keyword "yes") ::no}
                                            #{(class '1) (int \0)}})
                      false)))

(deftest test7 (is (= (pairwise-disjoint? #{#{distinct?}
                                            #{#(-> %) #(-> %)}
                                            #{#(-> %) #(-> %) #(-> %)}
                                            #{#(-> %) #(-> %) #(-> %)}})
                      true)))

(deftest test8 (is (= (pairwise-disjoint? #{#{(#(-> *)) + (quote mapcat) #_nil}
                                            #{'+ '* mapcat (comment mapcat)}
                                            #{(do) set contains? nil?}
                                            #{,,, #_,, empty?}})
                      false)))

(run-tests 'set.task153)