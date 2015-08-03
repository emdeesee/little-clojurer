(ns little-clojurer.doit-doitagain-test
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

(deftest test-member?
  (is (= true
         (let [a 'meat lat '(mashed potatoes and meat gravy)] (member? a lat))))
  (is (= false
         (let [a 'liver lat '(bagels and lox)] (member? a lat)))))
