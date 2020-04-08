(ns quil-a-programming-handbook.ex_31_11
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn new-arrowparticle [xpos ypos velx vely r]
     {:x xpos
      :y ypos
      :vx velx
      :vy vely
      :radius r
      :angle 0.0
      :shaft-length 20.0})
      
      

(defn update-arrowparticle [grv prt]
    (let [{:keys [x y vx vy] } prt
          vy (+ vy grv)
          y (+ y vy)
          x (+ x vx)
          angle (q/atan2 vy vx)]     
      (merge prt {:vy vy :y y :x x :angle angle})))
                     
           
(defn display-arrowparticle [prt]
  (let [{:keys [x y radius angle shaft-length] } prt]
    (q/stroke 255)
    (q/push-matrix)
    (q/translate x y)
    (q/rotate angle)
    (q/scale shaft-length)
    (q/stroke-weight (/ 1.0 shaft-length))
    (q/line 0 0 1 0)
    (q/line 1 0 0.7 -0.3)
    (q/line 1 0 0.7 0.3);
    (q/pop-matrix)))


(defn update-state [state]
  (merge state 
    {:particles (map (partial update-arrowparticle (:gravity state)) (:particles state))}))      

(defn setup []
  (q/no-stroke)
  {:gravity 0.1
   :particles (for [i (range 320)]
                (let [velX (+ (rand 7) 1)
                      velY (- (rand 6) 5)]
                  (new-arrowparticle 0 (/ (q/height) 2) velX velY 1.2)))})

(defn draw-state [state]
  (q/background 0)
  (doseq [p (:particles state)]
    (display-arrowparticle p)))
    

(q/defsketch practice
  :size [700 100]
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  
