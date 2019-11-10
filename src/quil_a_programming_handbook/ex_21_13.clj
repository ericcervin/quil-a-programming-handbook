(ns quil-a-programming-handbook.ex_21_13
  (:require [quil.core :as q]
            [quil.middleware :as m]))


(defn setup []
  (q/no-loop))
  

(defn draw []
  (let [u 5
        threshold 0.5]
    (doseq [y (range 0 100 u)]
      (doseq [x (range 0 100 u)]
       (let [r (rand)]
          (if (> r threshold)
              (q/line x y       (+ x u) (+ y u))
              (q/line x (+ y u) (+ x u) y      )))))))
            
     
    
(q/defsketch practice
  :size [100 100]
  :setup setup
  :draw draw
  :features [:keep-on-top])
  ;;:middleware [m/fun-mode])
  
