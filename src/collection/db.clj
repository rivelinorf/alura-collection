(ns collection.db)

(def order1 {:user 5
              :itens {
                      :mochila { :id "mochila", :amount 2, :price 80}
                      :camiseta { :id "camiseta", :amount 3, :price 40}
                      :tenis    { :id "tenis", :amount 1}}})
(def order2 {:user 1
             :itens {:mochila { :id "mochila", :amount 1, :price 80}
                     :camiseta { :id "camiseta", :amount 2, :price 40}
                     :tenis    { :id "tenis", :amount 1}}})
(def order3 {:user 5
             :itens {:mochila { :id "mochila", :amount 2, :price 80}
                     :camiseta { :id "camiseta", :amount 3, :price 40}
                     :tenis    { :id "tenis", :amount 1}}})
(def order4 {:user 4
             :itens {:mochila { :id "mochila", :amount 3, :price 80}
                     :camiseta { :id "camiseta", :amount 3, :price 40}
                     :tenis    { :id "tenis", :amount 1}}})
(def order5 {:user 3
             :itens {:mochila { :id "mochila", :amount 2, :price 80}
                     :camiseta { :id "camiseta", :amount 4, :price 40}
                     :tenis    { :id "tenis", :amount 1}}})
(def order6 {:user 2
             :itens {:mochila { :id "mochila", :amount 2, :price 80}
                     :camiseta { :id "camiseta", :amount 3, :price 40}
                     :tenis    { :id "tenis", :amount 1, :price 100}}})
(defn orders []
  [order1, order2, order3, order4, order5, order6])

(println (orders) )