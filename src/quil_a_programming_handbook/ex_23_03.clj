(ns quil-a-programming-handbook.ex_23_03
  (:require [quil.core :as q]))
           ;; [quil.middleware :as m]))

(defn setup []
   (q/no-stroke);
   (q/text-font (q/create-font "mono" 16))
   (q/text-align :center)) 

(defn draw []
  (q/background 0)
  (let [s (q/seconds)
        m (q/minute)
        h (q/hour)
        t (str (format "%02d" h) ":" (format "%02d" m) ":" (format "%02d" s))]
    (q/text t 50 50)))


(q/defsketch practice
  :size [100 100]
  :setup setup
  ;;:update update
  :draw draw
  :features [:keep-on-top])
  ;;:middleware [m/fun-mode])
  
