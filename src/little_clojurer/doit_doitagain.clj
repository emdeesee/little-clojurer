(ns little-clojurer.doit-doitagain
  (:use [little-clojurer.idiom]))

(def lat?
  (fn [l]
    (cond
      (null? l) true
      (and (seq? l) (atom? (first l))) (lat? (rest l))
      :else false)))

(def member?
  (fn [a lat]
    (cond
      (null? lat) false
      :else (or
             (= (first lat) a)
             (member? a (rest lat))))))


