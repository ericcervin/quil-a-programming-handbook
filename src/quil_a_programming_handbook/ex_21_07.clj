(ns quil-a-programming-handbook.ex_21_07
  (:require [quil.core :as q]
            [quil.middleware :as m]))


(defn setup []
  (q/stroke 255)
  (q/frame-rate 2))
  

(defn draw [state]
  (q/background 0)
  (let [num (+ (rand-int 50) 1)]
   (doseq [i (range num)]
     (q/line (* i 2) 0 (* i 2) 100))))
     
    
      
  
    
    
(q/defsketch practice
  :size [100 100]
  :setup setup
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  
