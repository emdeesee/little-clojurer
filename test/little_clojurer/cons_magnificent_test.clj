(ns little-clojurer.cons-magnificent-test
  (:require [clojure.test :refer :all]
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
   (is (= expect (rember a lat)))))
