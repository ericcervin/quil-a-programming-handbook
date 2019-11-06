(ns quil-a-programming-handbook.ex_13_15
  (:require [quil.core :as q]
            [quil.middleware :as m]))


(defn setup []
  (q/no-loop))
  
   



(defn draw []
  (q/background 0)
  (q/stroke 255,120)
  (q/translate 66 33)
  (doseq [i (range 18)]
    (q/stroke-weight i)
    (q/rotate (/ q/PI 12))
    (q/line 0 0 55 0)))
  
  
   
    
(q/defsketch practice
  :size [100 100]
  :setup setup
  :draw draw
  :features [:keep-on-top])
  ;;:middleware [m/fun-mode]
  
