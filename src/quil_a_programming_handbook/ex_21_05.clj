(ns quil-a-programming-handbook.ex_21_05
  (:require [quil.core :as q]
            [quil.middleware :as m]))


(defn setup []
  (q/stroke 255 122))
  

(defn draw [state]
  (q/background 0)
  (doseq [i (range 0 (q/width) 6)]
    (let [r (- (rand 20) 10)]
      (q/stroke-weight (q/abs r))
      (q/line (- i r) 100 (+ i r) 0))))
      
  
    
    
(q/defsketch practice
  :size [700 100]
  :setup setup
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  
