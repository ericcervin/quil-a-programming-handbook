(ns quil-a-programming-handbook.ex_13_07
  (:require [quil.core :as q]
            [quil.middleware :as m]))


(defn setup []
  {:img (q/load-image "/resources/skulls/cp_6_skull_5.png")
   :yellow  (q/color 220 214 41)
   :green   (q/color 110 164 32)
   :tan     (q/color 180 177 132)})



(defn draw [state]
  (q/tint (:yellow state))
  (q/image (:img state) 0 0 200 200)
  (q/tint (:green state))
  (q/image (:img state) 200 0 200 200)
  (q/tint (:tan state))
  (q/image (:img state) 400 0 200 200)) 
   
    
(q/defsketch practice
  :size [600 200]
  :setup setup
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  
  
