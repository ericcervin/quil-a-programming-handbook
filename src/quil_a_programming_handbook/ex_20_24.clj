(ns quil-a-programming-handbook.ex_20_24
  (:require [quil.core :as q]
            [quil.middleware :as m]))


(defn setup []
  (q/no-stroke)
  (q/fill 0)
  {:maxDistance (q/dist 0 0 (q/width) (q/height))})
  
   



(defn draw [state]
  (q/background 204)
  (doseq [i (range 0 (+ (q/width) 20) 20)]
    (doseq [j (range 0 (+ (q/height) 20) 20)]
      (let [mouseDist (q/dist (q/mouse-x) (q/mouse-y) i j)
            maxDistance (:maxDistance state)
            diameter (* 66.0 (/ mouseDist maxDistance))]
        
        (q/ellipse i j diameter diameter)))))
      
  
  
   
    
(q/defsketch practice
  :size [100 100]
  :setup setup
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  
