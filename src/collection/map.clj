(ns collection.map
  (:require [collection.db :as c.db]))

(println  (c.db/orders))
(println  (group-by :user (c.db/orders)))

(defn my-group-by
  [element]
  (:user element))

(println (group-by my-group-by (c.db/orders)))

(println (map count (vals (group-by my-group-by (c.db/orders)))))
(->> (c.db/orders)
     (group-by :user)
     vals
     (map count)
     println)

(defn count-by-user
  [[key value]]
  (count value))

(defn count-by-user
  [[key value]]
  [key (count value)])

(defn count-by-user
  [[key value]]
  {
   :user-id key
   :count (count value)})


(defn price-product [value]
  (* (:amount value) (:price value)))


(defn total-item
  [[key value]]
  ;(println value)
  (* (get value :amount 0) (get value :price 0)))

(defn total
  [itens]
  ;(println "\ntotal: " itens)
  (reduce + (map total-item itens)))

(defn total-price
  [value]
  (
    ->> value
        ;(println "itens" value)
    (map :itens)
    (map total)
        (reduce +)))


(defn count-by-user
  [[key value]]
  {
   :user-id key
   :count (count value)
   :price (total-price value)})

(->> (c.db/orders)
     (group-by :user)
     (map count-by-user)
     println)
