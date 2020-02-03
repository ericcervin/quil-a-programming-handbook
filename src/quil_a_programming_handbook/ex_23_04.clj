(ns quil-a-programming-handbook.ex_23_04
  (:require [quil.core :as q]))
           ;; [quil.middleware :as m]))

(defn setup []
   (q/stroke 255)) 

(defn draw []
  (q/background 0)
  (let [s (q/map-range (q/seconds) 0 59 0 99)
        m (q/map-range (q/minute) 0 59 0 99)
        h (q/map-range (q/hour) 0 23 0 99)] 
        
    (q/line s 0  s 33)
    (q/line m 34 m 66)
    (q/line h 67 h 100)))


(q/defsketch practice
  :size [100 100]
  :setup setup
  ;;:update update
  :draw draw
  :features [:keep-on-top])
  ;;:middleware [m/fun-mode])
  
