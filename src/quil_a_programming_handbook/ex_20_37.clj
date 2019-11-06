(ns quil-a-programming-handbook.ex_20_37
  (:require [quil.core :as q]
            [quil.middleware :as m]))


(defn setup []
  )

(defn draw [state]
  (let [offset 126.0
        scaleVal 126.0
        angleInc 0.2]
       (doseq [x (range -52 (q/width))]
         (let [y (+ offset (* scaleVal (q/sin (* angleInc x))))]
           (q/stroke y)
           (q/line x 0 (+ x 50) (q/height))))))
    
    
(q/defsketch practice
  :size [700 100]
  :setup setup
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  
