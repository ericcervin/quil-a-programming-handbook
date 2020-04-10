(ns quil-a-programming-handbook.ex_31_21
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn rules [a b c on off]
  (let [rls [0 0 0 1 1 1 1 0]]
    (cond 
      (and (= a on)  (= b on)   (= c on))   (rls 0)
      (and (= a on)  (= b on)   (= c on))   (rls 1)
      (and (= a on)  (= b off)  (= c on))   (rls 2)
      (and (= a on)  (= b off)  (= c off))  (rls 3)
      (and (= a off) (= b on)   (= c on))   (rls 4)
      (and (= a off) (= b on)   (= c off))  (rls 5)
      (and (= a off) (= b off)  (= c on))   (rls 6)
      (and (= a off) (= b off)  (= c off))  (rls 7))))         

(defn update-state [state]
  (merge state {:gen (+ (:gen state) 1)}))      

(defn setup []
  (let [on (q/color 256)
        off (q/color 0)]
   (q/frame-rate 8)
   (q/background 0)
   (q/set-pixel (/ (q/width) 2) 0 on)
   {:gen  1
    :on on
    :off off}))

(defn draw-state [state]
  (let [gen (:gen state)
        on (:on state)
        off (:off state)]
    (doseq [x (range (- (q/width) 1))]
      (let [left (q/get-pixel (- x 1) (- gen 1))
            me   (q/get-pixel x (- gen 1))
            right (q/get-pixel (+ x 1) (- gen 1))]
        (if (= (rules left me right on off) 1) (q/set-pixel x gen on))
        (if (> gen (- (q/height)) 1) (q/no-loop))))))

(q/defsketch practice
  :size [101 101]
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  


