(ns cljbridge.api
  (:require [clj-http.client :as client])
  (:import [java.time OffsetDateTime]
           [java.time.format DateTimeFormatter]))

(def weather-history-url "https://archive-api.open-meteo.com/v1/era5?hourly=temperature_2m")
(def forecast-url "https://api.open-meteo.com/v1/forecast?hourly=temperature_2m&")
(def geocoding-url "https://geocoding-api.open-meteo.com/v1/search?name=")

(defn- api-get [url]
  (:body (client/get url {:as :json})))

(defn- get-location [city]
  (-> (api-get (str geocoding-url city))
      :results
      first))

(defn- get-avg-temperature-forecast [{:keys [:latitude :longitude]}]
  (let [response (api-get (str forecast-url
                               "latitude=" latitude
                               "&longitude=" longitude))
        times (some-> response
                      :hourly
                      :time)
        temperatures (some-> response
                             :hourly
                             :temperature_2m)]
    {:avg-temperature (/ (reduce + temperatures) (count temperatures))
     :start-date (first times)
     :end-date (last times)}))

(def date-formatter (DateTimeFormatter/ISO_LOCAL_DATE))

(defn- current-date-minus-days [days]
  (-> (OffsetDateTime/now)
      (.minusDays days)
      (.format date-formatter)))

(defn- get-avg-temperature-history [{:keys [:latitude :longitude]}]
  (let [start-date (current-date-minus-days 31)
        end-date (current-date-minus-days 1)
        url (str weather-history-url
                 "&latitude=" latitude
                 "&longitude=" longitude
                 "&start_date=" start-date
                 "&end_date=" end-date)
        temperatures (->> (api-get url)
                          :hourly
                          :temperature_2m
                          (remove nil?))]
    {:avg-temperature (/ (reduce + temperatures) (count temperatures))
     :start-date start-date
     :end-date end-date}))

(defn history-handler [{:keys [path-params]}]
  (let [city (:city path-params)]
    {:status 200
     :body (assoc (get-avg-temperature-history (get-location city))
            :city city)}))

(defn forecast-handler [{:keys [path-params]}]
  (let [city (:city path-params)]
    {:status 200
     :body (assoc (get-avg-temperature-forecast (get-location city))
            :city city)}))

