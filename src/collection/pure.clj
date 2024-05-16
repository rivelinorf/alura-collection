(ns collection.pure
  (:require [collection.db :as c.db]
            [collection.logic :as l.logic]))

(println  (c.db/orders))

(println (l.logic/resume (c.db/orders)))

(let [resumo (l.logic/resume (c.db/orders))]
  (println (sort-by :price resumo)))

(let [resumo (l.logic/resume (c.db/orders))
      orders (c.db/orders)]
  (println (reverse (sort-by :price resumo)))
  (println (get-in orders [5 :itens :tenis :price])))


(defn order-by-user [orders]
  (->> orders
       l.logic/resume
       (sort-by :price)))

(let [resumo (c.db/orders)]
  (println (order-by-user resumo)))

(let [resumo (c.db/orders)]
  (println (first (order-by-user resumo))))

(let [resumo (c.db/orders)]
  (println (nth (order-by-user resumo) 4)))

(let [resumo (c.db/orders)]
  (println (take 2 (order-by-user resumo))))

(let [resumo (c.db/orders)]
  (println (filter #(> (:price %) 500) (order-by-user resumo))))

(let [resumo (c.db/orders)]
  (println (some #(> (:price %) 500) (order-by-user resumo))))
(let [resumo (c.db/orders)]
  (println (empty? (filter #(> (:price %) 500) (order-by-user resumo)))))