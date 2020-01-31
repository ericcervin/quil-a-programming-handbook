(ns quil-a-programming-handbook.ex_22_13
  (:require [quil.core :as q]
            [quil.middleware :as m]))


(defn setup []
   (q/no-stroke);
   (q/fill 255 180)
  {:angle 0.0
   :speed 0.05})
  
(defn update [state]
  (merge state {:angle (+ (:angle state) (:speed state))}))
         
        
     
  

(defn draw [state]
  (let [angle (:angle state)
        speed (:speed state)
        d1 (+ 65 (* 45 (q/sin angle)))
        d2 (+ 65 (* 45 (q/sin (+ angle q/QUARTER-PI))))
        d3 (+ 65 (* 45 (q/sin (+ angle q/HALF-PI))))]   
    (q/background 0)
    (q/ellipse 50 50 d1 d1)
    (q/ellipse 50 50 d2 d2)
    (q/ellipse 50 50 d3 d3)))
    
  

    
(q/defsketch practice
  :size [100 100]
  :setup setup
  :update update
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  
