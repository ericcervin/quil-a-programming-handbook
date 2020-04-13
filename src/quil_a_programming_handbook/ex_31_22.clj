;freezes on my computer after a couple frames - need to find a faster way
;to do the math on this grid of pixels - maybe quil has a built in
;grid that I've missed

(ns quil-a-programming-handbook.ex_31_22
  (:require [quil.core :as q]
            [quil.middleware :as m]))      

(defn set-map-xy [mp x y val]
  (assoc mp {:x x :y y} val))

(defn set-random-point [mp i]
  (set-map-xy mp (rand-int (q/width)) (rand-int (q/height)) 1))

(defn neighbors [mp x y]
  (+' (get mp {:x x :y (- y 1)} 0) ;; North
     (get mp {:x (+ x 1) :y (- y 1)} 0);; Northeast
     (get mp {:x (+ x 1) :y y } 0) ;;East
     (get mp {:x (+ x 1) :y (+ y 1)} 0) ;;southEast
     (get mp {:x x :y (+ y 1)} 0) ;;south
     (get mp {:x (- x 1) :y (+ y 1)} 0);;southwest
     (get mp {:x (- x 1) :y  y} 0);; west
     (get mp {:x (- x 1) :y  (- y 1)} 0)));; northwest
   


(defn update-state [state]
  (let [grd (:grid state)
        point-list (for [x (range 1 (q/width)) y (range 1 (q/height))]
                        (let [curr-xy (get grd {:x x :y y} 0)
                              nb (neighbors grd x y)]
                          (case (and (= curr-xy 1) (or (< nb 2) (> nb 3))) [x y 0];isolation death or overpopulation death
                                (and (= curr-xy 0) (= nb 3)) [x y 1];birth
                            :else                        [x y nb])))
        new-map (reduce #(set-map-xy %1 (%2 0) (%2 1) (%2 2)) {} point-list)]
    {:grid new-map}))

(defn setup []
  (q/frame-rate 8)
  (q/background 0)
  (let [density (* 0.3 (q/width) (q/height))]
    {:grid (reduce set-random-point {} (range density))}))
    

(defn draw-state [state]
  (doseq [x (range (- (q/width) 1))]
    (doseq [y (range (- (q/height) 1))]
      (if (= ((:grid state) {:x x :y y}) 1) (q/set-pixel x y (q/color 255))))))

(q/defsketch practice
  :size [540 140]
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])



