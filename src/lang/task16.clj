; Topic: language
; Subtopic: elementary

(ns
  ^{:author raptor_MVK}
  lang.task16
  (:use clojure.test))

(defn greeter
  "Given s, returns string 'Hello, s!'"
  [s] (str "Hello, " s "!"))

(deftest test1 (is (= (greeter "Dave") "Hello, Dave!")))

(deftest test2 (is (= (greeter "Jenn") "Hello, Jenn!")))

(deftest test3 (is (= (greeter "Rhea") "Hello, Rhea!")))

(run-tests 'lang.task16)