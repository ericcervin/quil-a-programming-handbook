(ns quil-a-programming-handbook.ex_28_24
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn new-ring [xpos ypos status]
     {:x  xpos
      :y  ypos
      :diameter 1
      :on status})
  
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

(defn setup []
  [(new-ring 0 0 false)])

(defn update [state]
  (map grow-ring
   (if (q/mouse-pressed?) (conj state (new-ring (q/mouse-x) (q/mouse-y) true))
                          state)))

(defn draw [state]
  (q/background 0)
  (doseq [r state] 
    (display-ring r)))

(q/defsketch practice
  :size [100 100]
  :setup setup
  :update update
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  
