; Topic: sequences

(ns
  ^{:author "raptor_MVK"}
  seqs.task150
  (:use clojure.test))

(defn palindrome
  "Given a number, returns an increasing lazy sequence of all palindromic numbers
  that are not less than that number"
  [_] ())

(deftest test1 (is (= (take 26 (palindrome 0))
                      [0 1 2 3 4 5 6 7 8 9 11 22 33 44 55 66 77 88 99 101 111 121 131 141 151 161])))

(deftest test2 (is (= (take 16 (palindrome 162))
                      [171 181 191 202 212 222 232 242 252 262 272 282 292 303 313 323])))

(deftest test3 (is (= (take 6 (palindrome 1234550000))
                      [1234554321 1234664321 1234774321 1234884321 1234994321 1235005321])))

(deftest test4 (is (= (first (palindrome (* 111111111 111111111))) (* 111111111 111111111))))

(deftest test5 (is (= (set (take 199 (palindrome 0))) (set (map #(first (palindrome %)) (range 0 10000))))))

(deftest test6 (is (= true (apply < (take 6666 (palindrome 9999999))))))

(deftest test6 (is (= (nth (palindrome 0) 10101) 9102019)))

(run-tests 'seqs.task83)