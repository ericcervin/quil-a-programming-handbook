(ns quil-a-programming-handbook.ex_31_10
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn new-limitedparticle [xpos ypos velx vely r]
     {:x xpos
      :y ypos
      :vx velx
      :vy vely
      :radius r})
      

(defn update-limitedparticle [grv prt]
    (let [{:keys [x y vx vy radius originX originY] } prt
          friction 0.99
          vx (* vx friction)
          vy (+ (* vy friction) grv)
          y (+ y vy)
          x (+ x vx)
          
          vx (if (or (> x  (- (q/width) radius)) (< x   radius)) (* vx -1) vx)
          x  (if (or (> x  (- (q/width) radius)) (< x   radius)) (q/constrain x radius (- (q/width) radius)) x)
          vy (if (> y  (- (q/height) radius)) (* vy -1) vy)
          y  (if (> y  (- (q/height) radius)) (- (q/height) radius) y)]                                     
         (merge prt {:vx vx :vy vy :y y :x x})))
                     
           
(defn display-limitedparticle [prt]
  (let [{:keys [x y radius] } prt]
   (q/ellipse x y (* radius 2) (* radius 2))))  


(defn update-state [state]
  (merge state 
    {:particles (map (partial update-limitedparticle (:gravity state)) (:particles state))}))      

(defn setup []
  (q/no-stroke)
  {:gravity 0.1
   :particles (for [i (range 80)]
                (let [velX (- (rand 4) 2)
                      velY (* i -1)]
                  (new-limitedparticle (/ (q/width) 2) (/ (q/height) 2) velX velY 2.2)))})

(defn draw-state [state]
  (q/fill 0 24)
  (q/rect 0 0 (q/width) (q/height))
  (q/fill 255)
  (doseq [p (:particles state)]
    (display-genparticle p)))
    

(q/defsketch practice
  :size [100 100]
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  
