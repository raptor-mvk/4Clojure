; Topic: miscellaneous

(ns
  ^{:author "raptor_MVK"}
  misc.task125
  (:use clojure.repl)
  (:use clojure.test))

(defn quine-wrapper
  "Wrapper around real quine function"
  [result?]
  (let [quine '(fn q
                 []
                 (let [s "(str \"(fn q [] (let [s \" \\\" (.replace (.replace s \"\\\\\" \"\\\\\\\\\")
                          \"\\\"\" \"\\\\\\\"\") \\\" \"] \" s \"))\")"]
                   (str "(fn q [] (let [s " \" (.replace (.replace s "\\" "\\\\") "\"" "\\\"") \" "] " s "))")))]
    (if result? (eval (str quine)) (str quine))))

(deftest test1 (is (= (quine-wrapper false) (quine-wrapper true))))

(run-tests 'misc.task125)