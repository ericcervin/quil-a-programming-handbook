(ns quil-a-programming-handbook.ex_13_15
  (:require [quil.core :as q]
            [quil.middleware :as m]))


(defn setup []
  (q/no-loop)
  (let [img0 (q/load-image "/resources/skulls/cp_6_skull_5.png")
        img1 (q/load-image "/resources/skulls/cp_6_skull_5.png")
        img2 (q/load-image "/resources/skulls/cp_6_skull_5.png")
        img3 (q/load-image "/resources/skulls/cp_6_skull_5.png")
        img4 (q/load-image "/resources/skulls/cp_6_skull_5.png")
        img5 (q/load-image "/resources/skulls/cp_6_skull_5.png")
        img6 (q/load-image "/resources/skulls/cp_6_skull_5.png")
        img7 (q/load-image "/resources/skulls/cp_6_skull_5.png")
        img8 (q/load-image "/resources/skulls/cp_6_skull_5.png")
        img9 (q/load-image "/resources/skulls/cp_6_skull_5.png")
        img10 (q/load-image "/resources/skulls/cp_6_skull_5.png")
        img11 (q/load-image "/resources/skulls/cp_6_skull_5.png")
        img12 (q/load-image "/resources/skulls/cp_6_skull_5.png")
        img13 (q/load-image "/resources/skulls/cp_6_skull_5.png")]
       
        
        
    (q/image-filter img1 :blur 1)
    (q/image-filter img2 :blur 4)
    (q/image-filter img3 :blur 8)
    (q/image-filter img4 :posterize 2)
    (q/image-filter img5 :posterize 4)
    (q/image-filter img6 :posterize 8)
    (q/image-filter img7 :threshold 0.2)
    (q/image-filter img8 :threshold 0.4)
    (q/image-filter img9 :threshold 0.8)
    (q/image-filter img10 :invert)
    (q/image-filter img11 :gray)
    (q/image-filter img12 :erode)
    (q/image-filter img13 :dilate)
    
    {:imglst [img0 img1 img2 img3 img4 img5 img6 img7 img8 img9 img10 img11 img12 img13]}))

   



(defn draw [state]
  (q/image (get-in state [:imglst 1])  0 0 200 200)
  (q/image (get-in state [:imglst 2])  200 0 200 200)
  (q/image (get-in state [:imglst 3])  400 0 200 200)
  (q/image (get-in state [:imglst 4])  0 200 200 200)
  (q/image (get-in state [:imglst 5])  200 200 200 200)
  (q/image (get-in state [:imglst 6])  400 200 200 200)
  (q/image (get-in state [:imglst 7])  0 400 200 200)
  (q/image (get-in state [:imglst 8])  200 400 200 200)
  (q/image (get-in state [:imglst 9])  400 400 200 200)
  (q/image (get-in state [:imglst 10])  0 600 200 200)
  (q/image (get-in state [:imglst 11])  200 600 200 200)
  (q/image (get-in state [:imglst 12])  400 600 200 200)
  (q/image (get-in state [:imglst 13])  600 600 200 200))
  
  
   
    
(q/defsketch practice
  :size [800 800]
  :setup setup
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])
  
