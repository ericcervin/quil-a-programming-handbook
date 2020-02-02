(ns quil-a-programming-handbook.ex_22_17
  (:require [quil.core :as q]
            [quil.middleware :as m]))


(defn setup []
   (q/no-stroke);
  {:incr 0.06
   :density 4
   :znoise 0.0})
  
(defn update [state]
  (merge state {:znoise (+ (:znoise state) (:incr state))}))
 

(defn draw [state]
  (let [znoise (:znoise state)
        incr (:incr state)
        density (:density state)
        ysteps (/ (q/height) density)
        xsteps (/ (q/width)  density)]
       
       (doseq [dy (range ysteps)
               dx (range xsteps)]
              (let [xnoise (* dx incr)
                    ynoise (* dy incr)
                    x      (* dx density)
                    y      (* dy density)
                    n      (* 255 (q/noise xnoise ynoise znoise))] 
                (q/fill n)
                (q/rect x y density density)))))
            
    
  

(q/defsketch practice
  :size [100 100]
  :setup setup
  :update update
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  
