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

(deftest test-insertR

  (let [new 'topping
        old 'fudge
        lat '(ice cream with fudge for dessert)
        expect '(ice cream with fudge topping for dessert)]
    (is (= expect (insertR new old lat))))

  (let [new 'jalapeño
        old 'and
        lat '(tacos tamales and salsa)
        expect '(tacos tamales and jalapeño salsa)]
    (is (= expect (insertR new old lat))))

  (let [new 'e
        old 'd
        lat '(a b c d f g d h)
        expect '(a b c d e f g d h)]
    (is (= expect (insertR new old lat)))))

(deftest test-insertL

  (let [new 'fudge
        old 'topping
        lat '(ice cream with topping for dessert)
        expect '(ice cream with fudge topping for dessert)]
    (is (= expect (insertL new old lat))))

  (let [new 'jalapeño
        old 'salsa
        lat '(tacos tamales and salsa)
        expect '(tacos tamales and jalapeño salsa)]
    (is (= expect (insertL new old lat))))

  (let [new 'e
        old 'd
        lat '(a b c d f g d h)
        expect '(a b c e d f g d h)]
    (is (= expect (insertL new old lat)))))
