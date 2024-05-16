(ns collection.logic)

(defn total-item
  [[key value]]
  ;(println value)
  (* (get value :amount 0) (get value :price 0)))

(defn total
  [itens]
  (reduce + (map total-item itens)))

(defn total-price
  [value]
  (
    ->> value
        (map :itens)
        (map total)
        (reduce +)))


(defn count-by-user
  [[key value]]
  {
   :user-id key
   :count (count value)
   :price (total-price value)})

(defn
  resume [orders]
  (->> orders
       (group-by :user)
       (map count-by-user)))
