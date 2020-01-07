; Topic: miscellaneous

(ns
  ^{:author "raptor_MVK"}
  misc.task102
  (:use clojure.test))

(defn into-camel-case
  "Given a string, converts it into CamelCase"
  [s]
  (let [words (clojure.string/split s #"-")]
    (apply str (first words) (map #(apply str (Character/toUpperCase ^char (first %)) (rest %)) (rest words)))))

(deftest test1 (is (= (into-camel-case "something") "something")))

(deftest test2 (is (= (into-camel-case "multi-word-key") "multiWordKey")))

(deftest test3 (is (= (into-camel-case "leaveMeAlone") "leaveMeAlone")))

(run-tests 'misc.task102)