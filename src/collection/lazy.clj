(ns collection.lazy
  (:require [collection.db :as c.db]
            [collection.logic :as l.logic]))
(println  (c.db/orders))

(println (l.logic/resume (c.db/orders)))

(defn maior-que? [order]
  println order
  (> (:price order) 300))
(let [resumo (l.logic/resume (c.db/orders))]
  (println (keep maior-que? resumo)))

(println (range 10))
(println (take 4 (range 10)))
(println (take 4 (range 100000000000000)))

(defn fil1 [value]
  (println "1 - value" value)
  (+ 1 value))

(defn fil2 [value]
  (println "2 - value" value)
  (+ 1 value))
(println (map fil1 (range 10)))

; LAZY - with chunk
(->> (range 100)
     (map fil1)
     (map fil2)
     println)

; EAGER
(->> (range 100)
     (mapv fil1)
     (mapv fil2)
     println)

; LAZY - with chunk
(->> [0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40]
     (map fil1)
     (map fil2)
     println)

; LAZY 100% - without chunk
(->> '( 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40)
     (map fil1)
     (map fil2)
     println)