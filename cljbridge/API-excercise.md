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
```clojure
     ["/api/forecast/:city" {:get {:handler api/forecast-handler}}]
```
- Reittimäärityksessä oleva keyword `:city` saadaan haettua backend-pyynnön sisältä `:path-params`-rakenteesta. Handler-funktio saa HTTP-pyynnön map-muotoisena parametrina.
```clojure
(defn forecast-handler [request]
  (let [city (:city (:path-params request))]
    ...))
```

## 6. Tee web-sivulle lomake, joka hakee keskilämpötilan ja näyttää sen palauttaman tuloksen

- Muokkaa `src/cljs/cljbridge/core.cljs` tiedostossa funktiota `send-request` siten, että se hakee datan rakentamastasi `/api/forecast/:city`-rajapinnasta.
- Et tarvitse `:form-params`-tietoa, sillä paikan nimi annetaan osana URL-polkua.
- Funktio tallentaa jo APIn palauttaman vastauksen rungon `result`-atomiin.
- Voit joutua valitsemaan `result`-atomista halutun tiedon backendissa käyttämästäsi keywordista, esim `(:avg-temperature @result)`

## 7. Bonus 1: Hae edellisten lisäksi myös historiallinen lämpötiladata

- Historiallinen lämpötiladata on saatavissa omasta rajapinnastaan: https://open-meteo.com/en/docs/historical-weather-api
- Esimerkki API url: `https://archive-api.open-meteo.com/v1/era5?latitude=52.52&longitude=13.41&start_date=2022-01-01&end_date=2022-07-13&hourly=temperature_2m`
- Lämpötiladata tarvitsee kaksi uutta parametria: `start_date` ja `end_date`. Voit käyttää joko kiinnitettyjä päivämääriä tai jos haluat, voit muodostaa päivämäärät ohjelmallisesti.
- Päivämäärien muodostamiseen käytetään Java-luokkia `OffsetDateTime` ja `DateTimeFormatter`:
```clojure
(def date-formatter (DateTimeFormatter/ISO_LOCAL_DATE))

(defn- current-date-minus-days [days]
  (-> (OffsetDateTime/now)
      (.minusDays days)
      (.format date-formatter)))
```
- Tee uusi funktio, joka osaa hakea historiallista lämpötiladataa
- Kytke tämä funktio reittimäärityksessä omaan URL-osoitteeseensa, esim `/api/history/:city`.
- Valitse frontissa lomakkeen syötteen pohjalta, kummasta APIsta tieto haetaan ja käsittele saatu data.

## 8. Bonus 2: Tutki APIn palauttamaa dataa ja rakenna joku muu tapa hyödyntää sitä 
