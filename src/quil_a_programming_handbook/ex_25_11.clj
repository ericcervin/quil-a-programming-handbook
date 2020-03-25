(ns quil-a-programming-handbook.ex_25_11
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn new-ring [xpos ypos]
     {:x  xpos
      :y  ypos
      :diameter 1
      :on false})
  
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
  {:r {:x 0 :y 0 :diameter 1 :on false}})

(defn update [state]
  (if (q/mouse-pressed?) {:r {:x (q/mouse-x) :y (q/mouse-y) :diameter 1 :on true}}
                         {:r (grow-ring (:r state))}))

(defn draw [state]
  (q/background 0)
  (display-ring (:r state)))

(q/defsketch practice
  :size [100 100]
  :setup setup
  :update update
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  
