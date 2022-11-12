# Fraktaalityöpajan ohjeet

1. lisää project.clj -tiedostoon :dependencies -kohtaan:

     
           [com.google/clojure-turtle "0.3.0"]
           [quil "2.2.6"]
                
2. lisää (löytyy env/clj/projektin-nimi/ -hakemiston alta)  repl.clj tiedostoon toiselle riville, ennen (:use .... -riviä:
               
           (:require [clojure-turtle.core :refer :all])
 
3. avaa uusi terminaali vs-coden alavalikosta (+ -merkistä)  ja käynnistä repl:
            
           lein repl
                

## Aloitetaan piirtäminen kilpikonnalla

1. luodaan uusi ikkuna replistä (eli terminaalin clojure-tulkista). Jos uutta ikkunaa ei ilmesty niin pyydä ohjaajalta apua.

           (new-window {:size [920 900]})

jos komento ei toimi, tarkista että olet tallentanut muutokset vs-codessa ja käynnistä repl uudestaan. Sen jälkeen voit ajaa ensin replissä

          (use 'clojure-turtle.core)
               
2. Testaa komentoja replistä 
                
           (forward 100)
           (right 90)
           (forward 50)
           (left 30)
           (forward 20)

           (setxy -100 -200)

           (clean)
           (home)
                
## Tehtävä 1.

1. Putsaa ikkuna ja piirrä neliö

Toisteisuudesta pääsee eroon repeat ja all -funktoilla:

          (repeat 9 (all (forward 100) (right 160)))
                
 ## Tehtävä 2.
 
 Tallennetaan kuvioita funktioihin. Luodaan avuksi uusi tiedosto src/clj -hakemiston alle. esim fractal.clj. Laitetaan tiedoston sisällöksi vastaava, muista vaihtaa namespaceen oman projektisi nimi!
 
           (ns projekti-nimi-vaihda-oikeaksi.fractal
              (:require [clojure-turtle.core :refer :all] ))

           (defn ikkuna []
              (new-window {:size [920 900]}))

            (defn nelio []
               (forward 100))
                    
Yhdistetään VsCode alussa käynnistettyyn repl -sessioon. 
- Klikkaa alavalikosta REPL⚡️ ja valitse "Connect to a running REPL in your project"
- Valitse Leiningen
- vscode ehdottaa porttia, joka hyvällä tuurilla on juuri oikea, eli localhost:numerosarja. Paina enteriä.
- testaa yhteyttä evaluoimalla (eli shift+enter tai alt+enter) ensimmäinen rivi.

Korjaa funktio *nelio* ja kutsu sitä evaluoimalla calvan avulla.

## Tehtävä 3.

Tässä työpajassa opetellaan käyttämään rekursiota! Rekursio tarkoittaa sitä, että kutsutaan funktion sisällä itseään. Eli esimerkiksi:

          (clean) (home)
          (defn tahti [sakarat pituus]
            (if (zero? sakarat) 
                  (forward pituus)
                  (do
                    (forward pituus)
                    (right 160)
                    (tahti (dec sakarat) pituus)
                    )))

Huomaatko millä rivillä funktio kutsuu itseään?

Rekursiota käytettäessä aina ensin mietitään lopetusehto, eli milloin lakataan kutsumasta funktiota itseään. Tässä tapauksessa funktion suoritus loppuu, kun *sakarat* -parametrin arvo on 0. Parametreja vähennetään jokaisella kutsukerralla *dec* -funktion avulla.

### 3.0 

Aina kun ikkuna näyttää sotkuiselta, voit kutsua (clean) ja (home) -funktioita

### 3.1. 

Kopioi ylläoleva *tahti* funktio omaan vector.clj -tiedostoosi ja evaluoi se. Kokeile kutsua sitä nollalla sakaralla ja pituudella 100.

### 3.2. 

Kokeile kutsua *tahti* -funktiota 9:llä sakaralla

### 3.3. 

Kokeile muuttaa `(right 160)` rivin sisältöä, eli kulman suuruutta. Kutsu *tahti* funktiota haluamillasi parametreilla. Muista evaluoida *tahti* uudestaan. Osaatko tehdä spiraalin?

### Bonus (tätä ei tarvitse vielä ymmärtää, mutta kokeile silti):
Yhdellä rekursiolla ja clojure-turtle -kirjaston repeat -funktion avulla voi tehdä jo aika monimutkaisia kuvioita.
![image](https://user-images.githubusercontent.com/5735068/201472148-35344573-4bbb-43d1-b381-10cd3cff1c98.png)

     (defn sierpi [minl length]
       (repeat 3
         (all
           (when (> length minl) (sierpi minl (/ length 2.0)))
           (forward length)
           (right 120))))
           
           (setxy -400 -400)

Kopioi tämä funktio itsellesi ja kutsu sitä 

     (sierpi 15 30)

Kokeile vaihtaa jälkimmäistä parametria isommaksi. Esim 60, 120, 300, 800. Muista käyttää clean-funktiota välissä

## Tehtävä 4.

Nyt kun rekursio on tuttu, voimme tehdä tosi siistejä juttuja kutsumalla funktioita monta kertaa saman funktion sisällä!

Vilkaistaan Wikipediasta [L-system](https://en.wikipedia.org/wiki/L-system) sivua. L-system on fraktaalikielioppi, joka on hyvin yksinkertainen. Koitetaan muuttaa näitä kielioppeja clojureksi.

# kochin käyrä

[Kochin käyrä](https://en.wikipedia.org/wiki/Koch_snowflake) on yksinkertainen fraktaali, joka muodostetaan seuraavalla kieliopilla:

     Alphabet : F
     Constants : +, −
     Axiom : F
     Production rules:
     F → F+F--F+F

Tässä, F tarkoitaa (forward pituus) lopetusehdossa ja rekursiota muulloin, - tarkoittaa (right 60) ja + tarkoittaa (left 60)

Clojureksi käännettynä ylläoleva kielioppi näyttää tältä. 

     (defn koch [dep length]
       (if (zero? dep)
         (forward length)
         (do
           (koch (dec dep) length)
           (right 60)
           (koch (dec dep) length)
           (left 60)
           (left 60)
           (koch (dec dep) length)
           (right 60)
           (koch (dec dep) length))))

### 4.0 Kokeile kopioida tämä funktio ja kutsua sitä

     (koch 1 10)
     
Kokeile kasvattaa ensimmäistä parametria, eli syvyyttä. Voit kokeilla vaikka kymmeneen asti, mutta jos laitat kovin ison luvun ensimmäiseksi parametriksi, tietokoneesi menee todennäköisesti aika jumiin.

     (koch 2 10)
     
## 4.1 C-kaari

Kokeile nyt itse tehdä [Levy C kaari](https://en.wikipedia.org/wiki/L%C3%A9vy_C_curve)


          Variables:	F
          Constants:	+ −
          Start:	F
          Rules:	F → +F−−F+
          
Tässä, F tarkoitaa (forward pituus) lopetusehdossa ja rekursiota muulloin, "+" tarkoittaa (right 45) ja "−" tarkoittaa (left 45).

Tee funktio nimeltä cline, jolla on parametrit syvyys ja pituus. kutsu sitä

     (setxy -100 -200)
     (cline 9 10)

## väri rgb-arvoina

    (color [0 0 255])
    
## animointi

jos haluat nähdä kilpikonnan liikkeen, laita johonkin väliin

     (wait 5)



