(ns quil-a-programming-handbook.ex_25_08
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn new-egg [xpos ypos t s]
   {:x xpos
    :y ypos
    :tilt t
    :scalar  (/ s 100.0)
    :angle 0})
  
(defn wobble-egg [egg]
  (merge egg {:tilt (/ (q/cos (:angle egg)) 8)
              :angle (+ (:angle egg) 0.1)}))

(defn display-egg [egg]
    (q/no-stroke)
    (q/fill 255)
    (q/push-matrix)
    (q/translate (:x egg) (:y egg))
    (q/rotate (:tilt egg))
    (q/scale (:scalar egg))
    (q/begin-shape)
    (q/vertex 0 -100)
    (q/bezier-vertex  25 -100 40 -65  40 -40)
    (q/bezier-vertex  40 -15  25  0   0   0)
    (q/bezier-vertex -25  0  -40 -15 -40 -40)
    (q/bezier-vertex -40 -65 -25 -100 0  -100)
    (q/end-shape)
    (q/pop-matrix))
  



(defn setup []
  {:humpty (new-egg 50 100 0 80)})

(defn update [state]
  {:humpty (wobble-egg (:humpty state))})

(defn draw [state]
  (q/background 0)
  (display-egg (:humpty state)))

(q/defsketch practice
  :size [100 100]
  :setup setup
  :update update
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  
