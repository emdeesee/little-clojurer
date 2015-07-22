(ns little-clojurer.test-doit-doitagain
  (:require [clojure.test :refer :all]
            [little-clojurer.doit-doitagain :refer :all]))

(deftest test-lat?
  (is (= true
         (let [l '(Jack Sprat could eat no chicken fat)] (lat? l))))
  (is (= false
         (let [l '((Jack) Sprat could eat no chicken fat)] (lat? l))))
  (is (= false
         (let [l '(Jack (Sprat could) eat no chicken fat)] (lat? l))))
  (is (= true
         (let [l '()] (lat? l)))))
