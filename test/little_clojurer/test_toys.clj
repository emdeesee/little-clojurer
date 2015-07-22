(ns little-clojurer.test-toys
  (:require [clojure.test :refer :all]
            [little-clojurer.idiom :refer :all]))

(deftest test-null?
  (is (= true
         (null? (quote ()))))
  (is (= false
         (let [l '(a b c)] (null? l))))
  (is (= false
         (let [a 'spaghetti] (null? a)))))

(deftest test-atom?
  (is (= true
         (let [s 'Harry] (atom? s))))
  (is (= false
         (let [s '(Harry had a heap of apples)] (atom? s))))
  (is (= true
         (let [l '(Harry had a heap of apples)] (atom? (first l)))))
  (is (= false
         (let [l '(Harry had a heap of apples)] (atom? (rest l))))))

