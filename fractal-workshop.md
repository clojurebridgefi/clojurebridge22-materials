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


