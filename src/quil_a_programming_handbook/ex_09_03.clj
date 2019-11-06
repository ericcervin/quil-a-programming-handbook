(ns quil-a-programming-handbook.ex_09_03
  (:require [quil.core :as q]
            [quil.middleware :as m]))


(defn setup []
  (q/no-fill)
  (q/stroke-weight 2)
  (q/stroke 0))


(defn draw []
   (let [gap 20
         arc-length  (/ (q/mouse-x) 95.0)]
     (q/background 255)
     (doseq [i (range gap (- (q/width) gap) gap)]
       (q/arc (/ (q/width) 2) (/ (q/height) 2) i i (q/radians i) (+ (q/radians i) arc-length))))) 
   
    
(q/defsketch practice
  :size [600 600]
  :setup setup
  :draw draw
  :features [:keep-on-top])
  ;;:middleware [m/fun-mode])
  
