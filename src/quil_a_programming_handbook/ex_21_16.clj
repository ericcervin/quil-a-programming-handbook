(ns quil-a-programming-handbook.ex_21_13
  (:require [quil.core :as q]
            [quil.middleware :as m]))


(defn setup []
  (q/no-loop))
  

(defn draw []
  (q/background 0)
  (doseq [y (range 0 (q/height))]
    (doseq [x (range 0 (q/width))]
      (let [i 0.04
            x-noise (* x i)
            y-noise (* y i)
            gray (* (q/noise x-noise y-noise) 255)]
           (q/stroke gray)
           (q/point x y)))))
            
      
            
     
    
(q/defsketch practice
  :size [700 100]
  :setup setup
  :draw draw
  :features [:keep-on-top])
  ;;:middleware [m/fun-mode])
  
