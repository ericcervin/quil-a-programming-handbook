(ns quil-a-programming-handbook.ex_24_14
  (:require [quil.core :as q]))
          
(defn setup []
  (q/frame-rate 2))


(defn leaf [x y size dir]
  (q/push-matrix)
  (q/translate x y)
  (q/scale size)
  (q/begin-shape)
  (q/vertex (* 1.0 dir) -0.7)
  (q/bezier-vertex (* 1.0 dir) -0.7 (* 0.4 dir) -1.0  0.0         0.0)
  (q/bezier-vertex  0.0         0.0 (* 1.0 dir)  0.4 (* 1.0 dir) -0.7)
  (q/end-shape)
  (q/pop-matrix)) 
  

(defn vine [x num-leaves leaf-size]
  (let [ht (q/height)
        gap (/ ht num-leaves)]
   (q/stroke 255)
   (q/line x 0 x ht)
   (q/no-stroke)
   (doseq [i (range num-leaves)]
      (let [r (rand-int gap)
            dir (if (even? i) 1 -1)]
           (leaf x (+ r (* gap i)) leaf-size dir)))))
  
  



(defn draw []
  (q/background 0)
  (let [leaves (+ 2 (rand-int 13))]
    (vine 33 leaves 16)))
          
                    


(q/defsketch practice
  :size [100 100]
  :setup setup
  :draw draw
  :features [:keep-on-top])
  
  
