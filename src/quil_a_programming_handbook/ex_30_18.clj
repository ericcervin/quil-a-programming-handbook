(ns quil-a-programming-handbook.ex_30_18
  (:require [quil.core :as q]
            [quil.middleware :as m]))



(defn new-moving-line [x, y, px, py]
  {:x1 x
   :y1 y
   :x2 px
   :y2 py})

(defn update-moving-line [ln]
  {:x1 (+ (:x1 ln) (- (rand 0.2) 0.1))
   :y1 (+ (:y1 ln) (- (rand 0.2) 0.1))
   :x2 (+ (:x2 ln) (- (rand 0.2) 0.1))
   :y2 (+ (:y2 ln) (- (rand 0.2) 0.1))})

(defn display-moving-line [ln]
  (q/line (:x1 ln) (:y1 ln) (:x2 ln) (:y2 ln)))

(defn update-state [state]
  (merge state {:lines (map update-moving-line (:lines state))}))      

(defn mouse-dragged [state event]
  (let [lines (:lines state)]
    (merge state {:lines (conj lines (new-moving-line (:x event) (:y event) (:p-x event) (:p-y event)))})));)));(assoc lines current-line (new-moving-line (:x event) (:y event) (:p-x event) (:p-y event)))})))
                 ;;:current-line current-line})))

(defn setup []
  (let [num-lines 500]
    {:lines []}))

(defn draw-state [state]
  (q/background 204)
  (doseq [i (:lines state)]
         (display-moving-line i)))  

(q/defsketch practice
  :size [300 100]
  :setup setup
  :update update-state
  :draw draw-state
  :mouse-dragged mouse-dragged
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  
