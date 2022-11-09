(ns cljbridge.middleware
  (:require
   [ring.middleware.content-type :refer [wrap-content-type]]
   [ring.middleware.params :refer [wrap-params]]
   [prone.middleware :refer [wrap-exceptions]]
   [ring.middleware.reload :refer [wrap-reload]]
   [ring.middleware.defaults :refer [site-defaults wrap-defaults]]
   [reitit.ring.middleware.muuntaja :as muuntaja]
   [reitit.ring.middleware.parameters :as parameters]
   [muuntaja.core :as m]))

(def middleware
  [#(wrap-defaults % (assoc-in site-defaults [:security :anti-forgery] false))
   wrap-exceptions
   wrap-reload])

(def ring-opts
  {:data
   {:muuntaja m/instance
    :middleware [parameters/parameters-middleware
                 muuntaja/format-middleware]}})
