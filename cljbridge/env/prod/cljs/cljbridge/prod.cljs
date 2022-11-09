(ns cljbridge.prod
  (:require [cljbridge.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
