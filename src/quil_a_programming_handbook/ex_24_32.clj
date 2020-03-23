(ns quil-a-programming-handbook.ex_24_32
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn setup []
  (q/no-stroke)
  (q/frame-rate 2)
  {:rs 0})

(defn update [state]
  {:rs (inc (:rs state))})
   
(defn draw-circle [x y radius num]
  (let [value (/ (* 255 num) 6)]
    (q/fill value 153)
    (q/ellipse x y (* radius 2) (* radius 2))
    (if (> num 1)
        (let [num (dec num)
              branches (+ (rand-int 4) 2)]
             (doseq [i (range branches)]
               (let [a (rand q/TWO-PI)
                     newx (+ x (* (q/cos a) 16.0 num))
                     newy (+ y (* (q/sin a) 6.0 num))]
                 (draw-circle newx newy (/ radius 2) num)))))))
                        
      
      ;;  (do (draw-circle (- x (/ radius 2)) (/ radius 2)  (dec num))
      ;;    (draw-circle (+ x (/ radius 2)) (/ radius 2)  (dec num))))))
      

(defn draw [state]
  (q/background 0)
  (q/random-seed (:rs state))
  (draw-circle 350 50 80 7))


(q/defsketch practice
  :size [700 100]
  :setup setup
  :update update
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  
