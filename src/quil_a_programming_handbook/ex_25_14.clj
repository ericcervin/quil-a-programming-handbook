(ns quil-a-programming-handbook.ex_25_14
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


(defn new-ring [xpos ypos]
     {:x  xpos
      :y  ypos
      :diameter 1
      :on true})
  
(defn grow-ring [ring]
  (let [diameter (:diameter ring)
        on (:on ring)
        diameter (if (:on ring) (+ diameter 0.5)
                                diameter)]
       (merge ring (if (> diameter 400) {:diameter 1 :on false}
                                        {:diameter diameter}))))           

(defn display-ring [ring]
   (q/no-fill)
   (q/stroke-weight 4)
   (q/stroke 204 153)
   (if (:on ring) (q/ellipse (:x ring) (:y ring) (:diameter ring) (:diameter ring))))


(defn new-eggring [x y t sp]
   {:egg (new-egg x y t sp)
    :ring (new-ring x (- y (/ sp 2)))})
    
(defn update-eggring [er]
  {:egg  (wobble-egg (:egg er))
   :ring (grow-ring (:ring er))})

(defn display-eggring [er]
  (display-egg (:egg er))
  (display-ring (:ring er)))
  

(defn setup []
  [(new-eggring 33 66 0.1 33)
   (new-eggring 66 90 0.05 66)])

(defn update [state]
  (map update-eggring state))

(defn draw [state]
  (q/background 0)
  (doseq [er state]
    (display-eggring er)))

(q/defsketch practice
  :size [100 100]
  :setup setup
  :update update
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  
