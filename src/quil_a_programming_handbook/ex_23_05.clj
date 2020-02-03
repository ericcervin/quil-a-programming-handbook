(ns quil-a-programming-handbook.ex_23_05
  (:require [quil.core :as q]))
           ;; [quil.middleware :as m]))

(defn setup [])
    

(defn draw []
  (q/background 0)
  (q/fill 80)
  (q/no-stroke)
  (q/ellipse 50 50 80 80)
  (let [s (- (q/map-range (q/seconds) 0 59 0 q/TWO-PI) q/HALF-PI)
        m (- (q/map-range (q/minute) 0 59 0 q/TWO-PI) q/HALF-PI)
        h (- (q/map-range (rem (q/hour) 12) 0 12 0 q/TWO-PI) q/HALF-PI)] 
     (q/stroke 255)   
     (q/line 50 50  (+ 50 (* 38 (q/cos s))) (+ 50 (* 38 (q/sin s))))
     (q/line 50 50  (+ 50 (* 30 (q/cos m))) (+ 50 (* 30 (q/sin m))))
     (q/line 50 50  (+ 50 (* 25 (q/cos h))) (+ 50 (* 25 (q/sin h))))))


(q/defsketch practice
  :size [100 100]
  :setup setup
  ;;:update update
  :draw draw
  :features [:keep-on-top])
  ;;:middleware [m/fun-mode])
  
