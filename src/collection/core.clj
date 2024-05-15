(ns collection.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))


(map println ["Deus" "Riva" "Keila" "Davi" "Lulu" "Zao" "Valda"])
(println (first ["Deus" "Riva" "Keila" "Davi" "Lulu" "Zao" "Valda"]))
(println (rest ["Deus" "Riva" "Keila" "Davi" "Lulu" "Zao" "Valda"]))
(println (rest []))
(println (next ["Deus" "Riva" "Keila" "Davi" "Lulu" "Zao" "Valda"]))
(println (next []))

; VARIACAO MAP COM PROBLEMAS NA STACK DE RECURSAO
(defn my-map [function itens]
  (let [primary (first itens)]
    (if primary
      (do
        (function primary)
        (my-map function (rest itens))))
    ))

(my-map println ["Deus" "Riva" "Keila" "Davi" "Lulu" "Zao" "Valda"])
(my-map println ["Deus" "Riva" false "Davi" "Lulu" "Zao" "Valda"])


(defn my-map [function itens]
  (let [primary (first itens)]
    (if (not (nil? primary))
      (do
        (function primary)
        (my-map function (rest itens))))
    ))
(my-map println ["Deus" "Riva" false "Davi" "Lulu" "Zao" "Valda"])

(my-map println (range 1000000))

; ----------------------------------------------------------------------
; VARIACAO MAP COM RECURSAO
(defn my-map [function itens]
  (let [primary (first itens)]
    (if (not (nil? primary))
      (do
        (function primary)
        (recur function (rest itens))))
    ))

(my-map println (range 1000))
(println (my-map #(println (+ % 1)) (range 1000)))
(println (map #(println (+ % 1)) (range 10)))

(my-map (fn [value] (println (+ value 1))) (range 1000))
(println (map (fn [value] (+ value 1)) (range 1000)))
(println (my-map (fn [value] (+ value 1)) (range 1000)))

; ----------------------------------------------------------------------
; VARIACAO REDUCE
(map println ["Deus" "Riva" "Keila" "Davi" "Lulu" "Zao" "Valda"])

(defn count-elements [total elements]
  (if (seq elements)
     (recur (inc total) (rest elements))
     total)
  )
(println (count-elements 0 ["Deus" "Riva" "Keila" "Davi" "Lulu" "Zao" "Valda"]))
(println (count-elements 0 []))

(defn my-function
  ([param1] (println param1))
  ([param1 param2] (println param1 "-" param2)))
(my-function "Riva")
(my-function "Riva" "Keila")

(defn count-elements
  ([elements] (count-elements 0 elements))
  ([total elements]
    (if (seq elements)
      (recur (inc total) (rest elements))
      total))
  )
(println (count-elements 0 ["Deus" "Riva" "Keila" "Davi" "Lulu" "Zao" "Valda"]))
(println (count-elements ["Deus" "Riva" "Keila" "Davi" "Lulu" "Zao" "Valda"]))
(println (count-elements 0 []))

; ----------------------------------------------------------------------
; VARIACAO REDUCE SEM RECURSAO
(defn count-elements
  [elements]
  (loop [total 0
         rest-elements elements]
    (if (seq rest-elements)
      (recur (inc total) (next rest-elements))
      total)))

(println (count-elements ["Deus" "Riva" "Keila" "Davi" "Lulu" "Zao" "Valda"]))
(println (count-elements []))
