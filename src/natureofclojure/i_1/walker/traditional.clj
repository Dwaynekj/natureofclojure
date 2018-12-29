;; Based on the Nature of Code
;; by Daniel Shiffman
;; http://natureofcode.com
;;
;; Specifically:
;; https://github.com/shiffman/The-Nature-of-Code-Examples/tree/master/Processing/introduction/NOC_I_1_RandomWalkTraditional
;;
(ns natureofclojure.i-1.walker.traditional
  (:require [quil.core :as qc]))

(def WIDTH 800)
(def HEIGHT 600)

(def walker (atom {:x (/ WIDTH 10.0)
                   :y (/ HEIGHT 10.0)}))

(defn render-walker [w]
  (qc/stroke 230 100 100)
  (qc/point (:x w) (:y w)))

(defn step-walker [w-atom]
  (let [choice (rand-int 4)]
    (cond (= choice 0) (swap! w-atom update-in [:x] #(qc/constrain-float (+ % 1) 0 WIDTH))
          (= choice 1) (swap! w-atom update-in [:x] #(qc/constrain-float (- % 1) 0 WIDTH))
          (= choice 2) (swap! w-atom update-in [:y] #(qc/constrain-float (+ % 1) 0 HEIGHT))
          (= choice 3) (swap! w-atom update-in [:y] #(qc/constrain-float (- % 1) 0 HEIGHT)))))

