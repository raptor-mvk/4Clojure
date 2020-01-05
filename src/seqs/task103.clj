; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task103
  (:use clojure.set)
  (:use clojure.test))

(defn gen-k-combinations
  "Given a number k and a sequence, generates all k-combinations of the given sequence"
  [k s]
  (if (> k (count s))
    #{}
    (if (= 0 k)
      #{#{}}
      (let [make-sequnces-from-tail (fn [head tail] (map #(conj %1 head) (gen-k-combinations (dec k) tail)))]
        (reduce into #{} (map #(make-sequnces-from-tail %1 (clojure.set/difference s #{%1})) s))))))

(deftest test1 (is (= (gen-k-combinations 1 #{4 5 6}) #{#{4} #{5} #{6}})))

(deftest test2 (is (= (gen-k-combinations 10 #{4 5 6}) #{})))

(deftest test3 (is (= (gen-k-combinations 2 #{0 1 2}) #{#{0 1} #{0 2} #{1 2}})))

(deftest test4 (is (= (gen-k-combinations 3 #{0 1 2 3 4})
                      #{#{0 1 2} #{0 1 3} #{0 1 4} #{0 2 3} #{0 2 4} #{0 3 4} #{1 2 3} #{1 2 4} #{1 3 4} #{2 3 4}})))

(deftest test5 (is (= (gen-k-combinations 4 #{[1 2 3] :a "abc" "efg"}) #{#{[1 2 3] :a "abc" "efg"}})))

(deftest test6 (is (= (gen-k-combinations 2 #{[1 2 3] :a "abc" "efg"})
                      #{#{[1 2 3] :a} #{[1 2 3] "abc"} #{[1 2 3] "efg"} #{:a "abc"} #{:a "efg"} #{"abc" "efg"}})))

(run-tests 'seqs.task103)