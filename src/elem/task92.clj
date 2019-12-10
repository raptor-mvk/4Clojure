; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task92
  (:use clojure.test))

(defn rom2num
  "Given a string, representing a roman number, returns this number"
  [s]
  (let [r (replace (zipmap "IVXLCDM" [1 5 10 50 100 500 1000]) s)]
    (+ (reduce + (map #(if (>= %1 %2) %1 (- %1)) r (rest r))) (last r))))

(deftest test1 (is (= 14 (rom2num "XIV"))))

(deftest test2 (is (= 827 (rom2num "DCCCXXVII"))))

(deftest test3 (is (= 3999 (rom2num "MMMCMXCIX"))))

(deftest test4 (is (= 48 (rom2num "XLVIII"))))

(run-tests 'elem.task92)