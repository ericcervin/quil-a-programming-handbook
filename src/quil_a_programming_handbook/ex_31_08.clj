(ns quil-a-programming-handbook.ex_31_08
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn new-genparticle [xpos ypos velx vely r ox oy]
     {:x xpos
      :y ypos
      :vx velx
      :vy vely
      :radius r
      :originX ox
      :originY oy})

(defn update-genparticle [grv prt]
    (let [{:keys [x y vx vy radius originX originY] } prt
          vy (+ vy grv)
          y (+ y vy)
          x (+ x vx)
          out (or (> x  (+ (q/width) radius))
                  (< x  (* -1 radius))
                  (> y  (+  (q/height) radius))
                  (< y  (* -1 radius)))]
         (merge prt (if out {:x originX :y originY  :vx (- (rand 2) 1) :vy (- (rand 2) 1)}
                            {:vy vy :y y :x x}))))
           
(defn display-genparticle [prt]
  (let [{:keys [x y vx vy radius originX originY] } prt]
   (q/ellipse x y (* radius 2) (* radius 2))))  


(defn update-state [state]
  (merge state 
    {:particles (map (partial update-genparticle (:gravity state)) (:particles state))}))      

(defn setup []
  (q/no-stroke)
  {:gravity 0.1
   :particles (for [i (range 200)]
                (let [velX (- (rand 2) 1)
                      velY -1]
                  (new-genparticle (/ (q/width) 2) (/ (q/height) 2) velX velY 5.0 (/ (q/width) 2) (/ (q/height) 2))))})

(defn draw-state [state]
  (q/fill 0 36)
  (q/rect 0 0 (q/width) (q/height))
  (q/fill 255 60)
  (doseq [p (:particles state)]
    (display-genparticle p)))
    

(q/defsketch practice
  :size [100 100]
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  
