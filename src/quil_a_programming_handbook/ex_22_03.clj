(ns quil-a-programming-handbook.ex_22_03
  (:require [quil.core :as q]
            [quil.middleware :as m]))


(defn setup []
   (q/no-stroke);
   (q/ellipse-mode :radius)
  {:x  50
   :y  50
   :radius 15
   :speed-x  1.0
   :speed-y  0.4
   :direction-x  1
   :direction-y  -1})
  
(defn update [state]
  (let [width (q/width)
        height (q/height)
        {:keys [x y radius direction-x direction-y speed-x speed-y] } state
        x (+ x (* speed-x direction-x))
        y (+ y  (* speed-y direction-y))]
    (merge state {:x x          
                  :direction-x (if (or (> x (- width radius)) (< x radius))
                                 (* -1 direction-x)
                                 direction-x)
                   :y y          
                   :direction-y (if (or (> y (- height radius)) (< y radius))
                                  (* -1 direction-y)
                                  direction-y)})))
     
  

(defn draw [state]
  (let [width (q/width)
        height (q/height)
        {:keys [x y radius] } state]
    (q/fill 0 12)
    (q/rect 0 0 width height)
    (q/fill 255)
    (q/ellipse x y radius radius)))
    
  

    
(q/defsketch practice
  :size [100 100]
  :setup setup
  :update update
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  
