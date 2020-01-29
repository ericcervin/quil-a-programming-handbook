(ns quil-a-programming-handbook.ex_21_10
  (:require [quil.core :as q]
            [quil.middleware :as m]))


(defn setup []
  (q/no-loop))
  
(defn draw []
  (let [points 900]
    (doseq [i (range points)]
         (let [angle (rand q/TWO-PI)
               scalar (+ (rand-int 30) 10)
               x (+ 50 (* scalar (q/cos angle)))
               y (+ 50 (* scalar (q/sin angle)))]
           (q/point x y)))))
  ;;float scalar = random(10,40);
  ;;float x = 50 + (cos(angle) * scalar);
  ;;float y = 50 + (sin(angle) * scalar);
  ;;point(x,y));)
     
    
(q/defsketch practice
  :size [100 100]
  :setup setup
  :draw draw
  :features [:keep-on-top])
  ;;:middleware [m/fun-mode]
  
