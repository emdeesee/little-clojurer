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
      (= old (first lat)) (cons old (cons new (rest lat)))
      :else (cons (first lat) (insertR new old (rest lat))))))

(def insertL
  (fn [new old lat]
    (cond
      (null? lat) (quote ())
      (= old (first lat)) (cons new lat)
      :else (cons (first lat) (insertL new old (rest lat))))))

(def subst
  (fn [new old lat]
    (cond
      (null? lat) (quote ())
      (= old (first lat)) (cons new (rest lat))
      :else (cons (first lat) (subst new old (rest lat))))))

(def subst2
  (fn [new o1 o2 lat]
    (cond
      (null? lat) (quote ())
      (or (= o1 (first lat)) (= o2 (first lat))) (cons new (rest lat))
      :else (cons (first lat) (subst new o1 o2 lat)))))
