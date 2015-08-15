(ns little-clojurer.cons-magnificent
  (:use [little-clojurer.idiom]))

(def rember
  (fn [a lat]
    (cond
      (null? lat) (quote ())
      (= a (first lat)) (rest lat)
      :else (cons (first lat) (rember a (rest lat))))))

(def firsts
  (fn [l]
    (cond
      (null? l) (quote ())
      :else (cons (first (first l)) (firsts (rest l))))))

(def insertR
  (fn [new old lat]
    (cond
      (null? lat) (quote ())
      (= old (first lat)) (cons (first lat) (cons new (rest lat)))
      :else (cons (first lat) (insertR new old (rest lat))))))
