(ns quil-a-programming-handbook.ex_20_38
  (:require [quil.core :as q]
            [quil.middleware :as m]))


(defn setup []
  (q/stroke 255))
  

(defn draw [state]
  (q/background 0)
  (let [scaleVal 6.0
        angleInc 0.19]
       (doseq [offset (range -10 (+ (q/width) 10) 5)]
         (doseq [y (range 0 (q/height) 2)]
           (let [angle (* angleInc y)
                 x (+ offset (* scaleVal (q/sin (+ angle (* offset q/PI)))))]
            
             (q/line x y x (+ y 2)))))))
           
    
    
(q/defsketch practice
  :size [700 100]
  :setup setup
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  
