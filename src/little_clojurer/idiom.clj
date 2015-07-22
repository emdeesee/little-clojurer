(ns little-clojurer.idiom)

(def atom?
  (fn [a]
    (not (seq? a))))

(def null?
  (fn [a]
    (or
     (nil? a)
     (= () a))))
