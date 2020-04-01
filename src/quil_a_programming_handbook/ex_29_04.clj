(ns quil-a-programming-handbook.ex_29_04
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn setup []
  (q/frame-rate 30)
  (let [num-frames 12]
   {:num-frames 12
    :top-frame  0
    :bottom-frame  0
    :images (for [i (range num-frames)] 
              (let [string (str "/resources/ani-" (format "%03d" i) ".gif")]
                   (q/load-image string)))
    :last-time  0}))

(defn update [state]
  (let [top-frame (rem (+ (:top-frame state) 1) (:num-frames state))]
       (merge state
           (if (> (- (q/millis) (:last-time state)) 500)
               {:top-frame top-frame 
                :bottom-frame (rem (+ (:bottom-frame state) 1) (:num-frames state))
                :last-time (q/millis)}
               {:top-frame top-frame}))))      

(defn draw [state]
  (q/image (nth (:images state) (:top-frame state)) 0 0)
  (q/image (nth (:images state) (:bottom-frame state)) 0 50))  

(q/defsketch practice
  :size [100 100]
  :setup setup
  :update update
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  
