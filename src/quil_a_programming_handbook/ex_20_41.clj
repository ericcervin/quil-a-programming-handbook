(ns quil-a-programming-handbook.ex_20_41
  (:require [quil.core :as q]
            [quil.middleware :as m]))


(defn setup []
  (q/fill 0)
  (q/no-stroke))
  

(defn draw [state]
  (q/background 204)
  (let [scalar (q/map-range (q/mouse-x) 0 (q/width) 4 20)]
    (doseq [deg (range 0 (* 360 6) scalar)]
      (let [angle (q/radians deg)
            radius (+ 1.0 (* (/ deg scalar) 0.34))
            x (+ 75 (* radius (q/cos angle)))
            y (+ 42 (* radius (q/sin angle)))]
           (q/ellipse x y 4 4)))))
    
    
(q/defsketch practice
  :size [100 100]
  :setup setup
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  
