
;;runs, but needs more debugging to run like the java original
(ns quil-a-programming-handbook.ex_31_24
  (:require [quil.core :as q]
            [quil.middleware :as m]))      

(defn update-state [state]
  
  (let [{:keys [x y direction]} state
        SOUTH 0
        EAST 1
        NORTH 2
        WEST 3
        height (q/height)
        width (q/width)
        on (q/color 255)
        off (q/color 0)
        y (cond (and (= direction SOUTH) (not= height y)) (inc y)                
                (and (= direction NORTH) (not= 0 y))      (dec y)
                :else y)
        y (cond (and (= direction SOUTH) (= height y))  0
                (and (= direction NORTH) (= 0 y))       (- height 1)
                :else y)
        x (cond (and (= direction EAST)  (not= width))    (inc x)
                (and (= direction WEST)  (not= 0 x))      (dec x)
                :else x)
        x (cond (and (= direction EAST)  (= width x))   0
                (and (= direction WEST)  (= 0 x))       (- width 1)
                :else x)
        cur-xy-col (q/color (q/get-pixel x y))
        direction  (cond (and (= cur-xy-col on) (= direction SOUTH))   WEST
                         (and (= cur-xy-col on) (not= direction SOUTH))   (dec direction)
                         (and (= cur-xy-col off) (= direction WEST))  SOUTH
                         (and (= cur-xy-col off) (not= direction WEST))  (inc direction)
                         :else direction)
                         
         col (if (= cur-xy-col on) off on)]
       ;;(prn on)
       ;;(prn off)
       ;;(prn col)
       ;;(prn cur-xy-col)
       (merge state {:x x :y y :col col :direction direction})))      
        

(defn setup []
  (q/background 0)
  {:x (/ (q/width) 2)
   :y (/ (q/height) 2)
   :direction 2
   :col (q/color 0)})
  
    

(defn draw-state [state]
  (let [x (:x state)
        y (:y state)
        col (:col state)]
     ;;(prn state)
     (q/set-pixel x y col)))    
    

(q/defsketch practice
  :size [100 100]
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])



