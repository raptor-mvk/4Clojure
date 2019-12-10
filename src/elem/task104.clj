; Topic: elementary

(ns
  ^{:author "raptor_MVK"}
  elem.task104
  (:use clojure.test))

(defn num2rom
  "Given N smaller than 4000, return the corresponding roman numeral"
  [n]
  (let [rom (fn [n i v x] (condp >= n
                            0 ""
                            3 (apply str (repeat n i))
                            4 (str i v)
                            8 (apply str (concat [v] (repeat (- n 5) i)))
                            9 (str i x)))]
    (apply str (map #(rom (- (int %1) (int \0)) %2 %3 %4) (format "%04d" n)
                 "MCXI" "MDLV" "MMCX"))))

(deftest test1 (is (= "I" (num2rom 1))))

(deftest test2 (is (= "XXX" (num2rom 30))))

(deftest test3 (is (= "IV" (num2rom 4))))

(deftest test4 (is (= "CXL" (num2rom 140))))

(deftest test5 (is (= "DCCCXXVII" (num2rom 827))))

(deftest test6 (is (= "MMMCMXCIX" (num2rom 3999))))

(deftest test7 (is (= "XLVIII" (num2rom 48))))

(run-tests 'elem.task104)