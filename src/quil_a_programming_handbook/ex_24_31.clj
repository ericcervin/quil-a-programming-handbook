(ns quil-a-programming-handbook.ex_24_31
  (:require [quil.core :as q]))

(defn setup []
   (q/no-loop)
   (q/no-stroke))
   
(defn draw-circle [x radius num]
  (let [tt (* 126 (/ num 4.0))]
    (q/fill tt)
    (q/ellipse x 50 (* radius 2) (* radius 2))
    (if (> num 0)
        (do (draw-circle (- x (/ radius 2)) (/ radius 2)  (dec num))
            (draw-circle (+ x (/ radius 2)) (/ radius 2)  (dec num))))))
      

(defn draw []  
  (draw-circle 63 85 6))

(q/defsketch practice
  :size [100 100]
  :setup setup
  :draw draw
  :features [:keep-on-top])
  
