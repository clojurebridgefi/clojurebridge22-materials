# Johdanto rajapintoihin

## 1. Mikä on API eli rajapinta?

- Dokumentoitu tapa jolla kaksi ohjelmistoa kommunikoi keskenään
- Tässä kontekstissa keskitytään web apeihin. On myös muita rajapintoja (kielet, kirjastot, käyttöjärjestlmät, laitteisto).
- Tyypillisimmät arkkitehtuurit: [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) ja [GraphQL](https://en.wikipedia.org/wiki/GraphQL)
- Yleisimmät dataformaatit: [JSON](https://en.wikipedia.org/wiki/JSON) ja [XML](https://en.wikipedia.org/wiki/XML)
- Taaksepäinyhteensopivuus

## 2. Miksi APIt ovat tärkeitä?

- Ohjelmointi on isojen ongelmien pilkkomista pienempiin.
- Pilkkominen voi tapahtua yhden ajoympäristön sisällä (monoliitti) tai hajauttamalla erillisiin palveluihin (mikropalvelut)
- *Kaikkien* komponenttien välillä on rajapinta. Mikropalvelujen välillä kommunikoidaan tyypillisesti verkon yli web APIlla.

## 3. Työpajan sisältö

1. Rakennetaan ohjelma, joka hyödyntää muutamaa olemassaolevaa avointa rajapintaa
   * [Weather Forecast API](https://open-meteo.com/en/docs)
   * [Geocoding API](https://open-meteo.com/en/docs/geocoding-api)

1. Luodaan oma backend API edellisten ympärille osana cljbridge reagent-projektia

1. Rakennetaan reagentilla lomake, joka osaa käyttää rakentamaamme APIa ja näyttää tuloksen selaimen sivulla

1. Bonus 1: Hae edellisten lisäksi myös historiallinen lämpötiladata

   * [Historical Weather API](https://open-meteo.com/en/docs/historical-weather-api)
     * Vaatii myös päivämäärien käsittelyä, jonka yhteydessä puhutaan hieman [Clojure-Java-interopista](https://clojure.org/reference/java_interop) (yksi rajapinta tämäkin)


1. Bonus 2: tutki APIn palauttamaa dataa ja rakenna joku muu tapa hyödyntää sitä 

## 4. Setup

1. Lisää `project.clj` tiedostoon kaksi uuttaa riippuvuutta `:dependencies` avaimen alle:
   ```
                 [clj-http "3.12.3"]
                 [cheshire "5.11.0"]
   ```

   - Clj-http on backendissä käyettävä HTTP client
   - Cheshire on clj-http:n käyttämä JSON-jäsennin (parseri)
1. Käynnistä koko projektin kääntäjä `figwheel` uudelleen
   ```
   $ lein figwheel
   ```
1. Käynnistä lisäksi REPL, jotta voit kehittää backend-koodia interaktiivisesti
   ```
   $ lein repl
   ```

Valmis runko oman `cljbridge.api`-nimiavaruuden lähtökohdaksi. Tallenna se tiedostoon `src/clj/cljbridge/api.clj`:
```clojure
(ns cljbridge.api
  (:require [clj-http.client :as client])
  (:import [java.time OffsetDateTime]
           [java.time.format DateTimeFormatter]))

(def forecast-url "https://api.open-meteo.com/v1/forecast?hourly=temperature_2m&latitude=60.16952&longitude=24.93545")
(def weather-history-url "https://archive-api.open-meteo.com/v1/era5?hourly=temperature_2m")
(def geocoding-url "https://geocoding-api.open-meteo.com/v1/search?name=")

(defn- api-get [url]
  (:body (client/get url {:as :json})))
```

Lisäksi vinkkinä Clojure Cheatsheet: https://clojure.org/api/cheatsheet

