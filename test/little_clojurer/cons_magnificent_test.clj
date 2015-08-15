(ns little-clojurer.cons-magnificent-test
  (:require [clojure.test :refer :all]
            [little-clojurer.idiom :refer :all]
            [little-clojurer.cons-magnificent :refer :all]))

(deftest test-rember

  (let [a 'mint
        lat '(lamb chops with mint jelly)
        expect '(lamb chops with jelly)]
    (is (= expect (rember a lat))))

  (let [a 'mint
        lat '(lamb chops with mint flavored mint jelly)
        expect '(lamb chops with flavored mint jelly)]
    (is (= expect (rember a lat))))

  (let [a 'toast
        lat '(bacon lettuce and tomato)
        expect lat]
    (is (= expect (rember a lat))))

  (let [a 'cup
        lat '(coffee cup tea cup and hick cup)
        expect '(coffee tea cup and hick cup)]
    (is (= expect (rember a lat))))

  (let [a 'sauce
        lat '(soy sauce and tomato sauce)
        expect '(soy and tomato sauce)]
    (is (= expect (rember a lat)))))

(deftest test-firsts

  (let [l '((apple peach pumpkin)
            (plum pear cherry)
            (grape raison pea)
            (bean carrot eggplant))
        expect '(apple plum grape bean)]
    (is (= expect (firsts l))))

  (let [l '((a b) (c d) (e f))
        expect '(a c e)]
    (is (= expect (firsts l))))

  (is (null? (firsts (quote ()))))

  (let [l '((five plums)
            (four)
            (eleven green oranges))
        expect '(five four eleven)]
    (is (= expect (firsts l))))

  (let [l '(((five plums) four)
            (eleven green oranges)
            ((no) more))
        expect '((five plums) eleven (no))]
    (is (= expect (firsts l)))))
