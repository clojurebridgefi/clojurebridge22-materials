(ns cljbridge.handler
  (:require [cljbridge.middleware :refer [middleware ring-opts]]
            [clojure.string :as s]
            [config.core :refer [env]]
            [hiccup.page :refer [html5 include-css include-js]]
            [reitit.ring :as reitit-ring]))

(def mount-target
  [:div#app
   [:h2 "Welcome to cljbridge"]
   [:p "please wait while Figwheel/shadow-cljs is waking up ..."]
   [:p "(Check the js console for hints if nothing exciting happens.)"]])

(defn head []
  [:head
   [:meta {:charset "utf-8"}]
   [:meta {:name "viewport"
           :content "width=device-width, initial-scale=1"}]
   (include-css (if (env :dev) "/css/site.css" "/css/site.min.css"))])

(defn loading-page []
  (html5
   (head)
   [:body {:class "body-container"}
    mount-target
    (include-js "/js/app.js")]))

(defn index-handler
  [_request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (loading-page)})

(defn form-handler [request]
(let [params (:params request)
      text (:text params)
      transform (:selection params)
      text-transformed
      (case transform
        "lower" (s/lower-case text)
        "upper" (s/upper-case text)
        text)] 
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body text-transformed}))

(def app
  (reitit-ring/ring-handler
   (reitit-ring/router
    [["/" {:get {:handler index-handler}}]
     ["/items"
      ["" {:get {:handler index-handler}}]
      ["/:item-id" {:get {:handler index-handler
                          :parameters {:path {:item-id int?}}}}]]
     ["/clojurebridge" {:get {:handler index-handler}}]
     ["/about" {:get {:handler index-handler}}]
     ["/form" {:post {:handler form-handler}}]]
    ring-opts)
   (reitit-ring/routes
    (reitit-ring/create-resource-handler {:path "/" :root "/public"})
    (reitit-ring/create-default-handler))
   {:middleware middleware}))