(ns quil-a-programming-handbook.ex_28_25
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn new-spot [xpos ypos dia sp]
     {:x  xpos
      :y  ypos
      :diameter dia
      :speed sp
      :direction 1})
  
(defn move-spot [spot]
 (let [
       direction (:direction spot)
       y (+ (:y spot) (* (:speed spot) direction))]
      (merge spot {:y y
                   :direction (if (or (> y (- (q/height) (/ (:diameter spot) 2))) 
                                      (< y (/ (:diameter spot) 2)))
                                  (* direction -1)
                                  direction)})))                                    
                                      

(defn display-spot [spot]
  (q/ellipse (:x spot) (:y spot) (:diameter spot) (:diameter spot)))   

(defn setup []
  (let [num-spots 70
        dia (/ (q/width) num-spots)]
       (for [i (range num-spots)]
         (let [x (+ (/ dia 2) (* i dia))
               rate (+ 0.1 (rand 1.9))]
           (new-spot x 50 dia rate)))))
    

(defn update [state]
  (map move-spot state))

(defn draw [state]  
  (q/fill 0 12)
  (q/rect 0 0 (q/width) (q/height))
  (q/fill 255)
  (doseq [i state] 
         (display-spot i)))
  

(q/defsketch practice
  :size [700 100]
  :setup setup
  :update update
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  
