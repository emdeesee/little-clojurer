(ns little-clojurer.cons-magnificent
  (:use [little-clojurer.idiom]))

(def rember
  (fn [a lat]
    (cond
      (null? lat) (quote ())
      (= a (first lat)) (rest lat)
      :else (cons (first lat) (rember a (rest lat))))))

(def trember
  "Like rember, but tail-recursive."
  (fn [a lat]
    (loop [lat lat result '()]
      (cond
        (null? lat) (reverse result)
        :else (recur (rest lat)
                     (cond
                       (= a (first lat)) result
                       :else (cons (first lat) result)))))))

(def insertR
  (fn [new old lat]
    (cond
      (null? lat) (quote ())
      (= old (first lat)) (cons (first lat) (cons new (rest lat)))
      :else (cons (first lat) (insertR new old (rest lat))))))
