# Rajapintatehtävät

Käynnistä REPL, jossa voit kokeilla toteutusta:
```
lein repl
```

Kun saat toteutuksen toimimaan REPLissä, kopioi koodi `api.clj`-tiedostoon ja tee siitä funktio, esim:
```clojure
(defn increment-two [n]
  (+ 2 n))
```

## 1. Hae Helsingin lämpötilaennuste rajapinnasta

- Rajapinnan dokumentaatio: https://open-meteo.com/en/docs
- Helsingin koordinaatit ovat
  - `latitude=60.16952`
  - `longitude=24.93545`
- Helsingin lämpötilaennuste löytyy osoitteesta `https://api.open-meteo.com/v1/forecast?hourly=temperature_2m&latitude=60.16952&longitude=24.93545`
- Saat tehtyä API-haun `api-get`-funktiolla.
- Tallenna vastaus REPLissä johonkin nimeen `def`-komennolla, esim:
```clojure
(def response (api-get url))
```
- Tutki REPLissä mitä tietoa vastauksessa tulee. Kun vastauksena on map, saat mapin avaimet `keys`-funktiolla. Jos vastaus on vektori, saat ensimmäisen elementin `first`-funktiolla.
- Saat valittua dataa `map`-tietorakenteesta käyttämällä keywordia (esim. `:temperatures`) funktionimenä. Vektorin pituuden voi laskea `count`-funktiolla:
    ```clojure
    (def forecast {:temperatures [10.2 10.5]
                   :city "Helsinki"})
    => (:temperatures forecast)
    [10.2 10.5]
    => (count (:temperatures forecast))
    2
    ```

## 2. Laske lämpötilaennusteen keskilämpötila

- Tutki rajapinnan palauttamaa dataa ja mieti miten lasket keskilämpötilan
  - Vinkki: laskimme Clojurebridge 1. workshopissa keskiarvon pituuksille 
- Listan tai vektorin elementtien summan voi laskea `reduce`-funktiolla:
   ```
    => (reduce + [1 2 3])
    6
   ```

## 3. Hae koordinaatit halutulle paikannimelle

- Tee funktio, joka palauttaa koordinaatit `map`-tietorakenteessa halutulle paikannimelle
- Rajapinnan dokumentaatio: https://open-meteo.com/en/docs/geocoding-api
- Helsingin koordinaatit saa haettua osoitteesta: `https://geocoding-api.open-meteo.com/v1/search?name=Helsinki`
- Voit yhdistää merkkijonoja `str`-funktiolla:
   ```
   => (str "tulos on " (reduce + [1 2 3]))
   "tulos on 6"
   ```

## 4. Yhdistä koordinaattien ja ennusteen haku

- Tee funktio, joka hakee keskilämpötilaennusteen halutulle kaupungille
- Joudut liittämään koordinaatit osaksi ennuste-APIn urlin alkua ja yhdistämään parametrit `&`-merkillä:
    ```clojure
    (str url "&latitude=" latitude "&longitude=" longitude)
    ```

## 5. Luo oma rajapinta backendiin joka palauttaa ennusteen keskilämpötilan annetulle paikannimelle

- Tee funktio, joka palauttaa HTTP-vastauksen
- Funktion kuuluu palauttaa `map`-tietorakenne, jossa on paluukoodi `:status` (200 = OK) sekä varsinainen runko `:body`. Mikäli runko on `map`-muodossa muuntaa käytetyt middlewaret sen JSON-muotoon automaattisesti
```clojure
{:status 200
 :body {:city "Helsinki"
        :country "Finland"}}
```
- Lisää `api` osaksi `handler.clj`:n `requireja`:
```clojure
(ns cljbridge.handler
  (:require ...
            [cljbridge.api :as api]))
```
- Funktio liitetään osaksi backendin reittimääritelmää. Se löytyy `handler.clj`:n lopusta `app`-määritelmästä, esim:
```
     ["/api/forecast/:city" {:get {:handler api/forecast-handler}}]
```
