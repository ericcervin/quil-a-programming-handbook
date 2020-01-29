(ns quil-a-programming-handbook.ex_22_04
  (:require [quil.core :as q]
            [quil.middleware :as m]))


(defn setup []
   (q/no-stroke);
   
  {:d 20
   :speed  1.0
   :direction  1})
  
(defn update [state]
  (let [width (q/width)
        height (q/height)
        speed (:speed state)
        direction (:direction state)
        d  (+ (:d state) (* speed direction))
        direction (if (or (> d width) (< d (/ width 10)))
                      (* -1 direction)
                      direction)]
        
       {:d d         
        :direction direction
        :speed speed})) 
        
     
  

(defn draw [state]
  (let [width (q/width)
        height (q/height)
        d  (:d state)]
    (q/background 0)
    (q/fill 255 204)
    (q/ellipse 0 50 d d)
    (q/ellipse 100 50 d d)
    (q/ellipse 50 0 d d)
    (q/ellipse 50 100 d d)))
    
  

    
(q/defsketch practice
  :size [100 100]
  :setup setup
  :update update
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  
