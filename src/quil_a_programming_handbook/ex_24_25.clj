(ns quil-a-programming-handbook.ex_24_25
  (:require [quil.core :as q]
            [quil.middleware :as m]))


(defn setup []
   (q/stroke 255 204)
   {:incr 0.0})
 
  
(defn update [state]
  (merge state {:incr (+ (:incr state) 0.01)}))
 
(defn tail [xpos units angle]
  (q/push-matrix)
  (q/translate xpos 0)
  (doseq [i (range units 0 -1)]
    (q/stroke-weight i)
    (q/line 0 0 0 8)
    (q/translate 0 8)
    (q/rotate angle))
  (q/pop-matrix))

(defn draw [state]
  (let [incr (:incr state)
        angle (+ (/ (q/sin incr) 10.0) (/ (q/sin (* incr 1.2)) 20.0))]
    (q/background 0)
    (tail 19 9  (/ angle 1.3))
    (tail 33 12 angle)
    (tail 44 10 (/ angle 1.3))
    (tail 62 5 angle)
    (tail 88 7 (* angle 2))))
       
  

(q/defsketch practice
  :size [100 100]
  :setup setup
  :update update
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  
