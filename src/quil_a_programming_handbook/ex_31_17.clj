(ns quil-a-programming-handbook.ex_31_17
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn new-spring2D [xpos ypos m g]
     {:x xpos
      :y ypos
      :mass m
      :gravity g
      :radius 10
      :nx xpos
      :ny ypos
      :stiffness 0.2
      :damping 0.7
      :vx 0
      :vy 0})
      

(defn join-spring2D [chain next]
  (let [px (:x (last chain))
        py (:y (last chain))
        force-x (* (- px  (:x next ))  (:stiffness next))
        ax (/ force-x (:mass next))
        vx  (* (:damping next) (+ (:vx next) ax))
        x (+ (:x next) vx)
        
        force-y (* (- py  (:y next ))  (:stiffness next))
        force-y (+ force-y (:gravity next))
        ay (/ force-y (:mass next))
        vy  (* (:damping next) (+ (:vy next) ay))
        y (+ (:y next) vy)
        
        next-link (merge next {:x x :y y :vx vx :vy vy :nx px :ny py})]
   (conj chain next-link)))
               
           
(defn display-spring2D [sp]
  (let [{:keys [x y nx ny radius] } sp]
    (q/no-stroke)
    (q/ellipse x y (* 2 radius) (* 2 radius))
    (q/stroke 255);
    (q/line x y nx ny)))


(defn update-state [state]
  (merge state 
    {:springs (reduce join-spring2D [(new-spring2D (q/mouse-x) (q/mouse-y) 3.0 5.0)] (rest (:springs state)))}))      

(defn setup []
  (q/fill 0)
  (let [num-springs 12
        mass 3.0
        gravity 5.0]
    {:gravity 5.0
     :mass 3.0
     :springs (for [i (range num-springs)]
                (new-spring2D (/ (q/width) 2) (* i (/ (q/height) num-springs)) mass gravity))}))

(defn draw-state [state]
  (q/background 204)
  (doseq [sp (take 12 (:springs state))]
    (display-spring2D sp)))
    

(q/defsketch practice
  :size [100 400]
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  


