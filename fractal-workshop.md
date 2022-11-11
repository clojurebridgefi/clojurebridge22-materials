# Fraktaalityöpajan ohjeet

1. lisää project.clj -tiedostoon :dependencies -kohtaan:

     
                [com.google/clojure-turtle "0.3.0"]
                [quil "2.2.6"]
                
2. lisää (löytyy env/clj/projektin-nimi/ -hakemiston alta tiedostoon repl.clj toiselle riville, ennen (:use .... -riviä:
               
               (:require [clojure-turtle.core :refer :all])
 
3. avaa terminaali (tai powershell) ja navigoi cd-komennolla nykyisen projektin hakemistoon, esim:
 
                cd proj/clojurebridge2/
                
4. käynnistä repl
            
                lein repl
                

## Aloitetaan piirtäminen kilpikonnalla

1. luodaan uusi ikkuna replistä

               (new-window {:size [920 900]})
               
2. Testaa komentoja 
                
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
 
 Tallennetaan kuvioita funktioihin. Luodaan avuksi uusi tiedosto src/clj -hakemiston alle. esim fractal.clj
 
                (ns projekti-nimi-vaihda-oikeaksi.fractal
                   (:require [clojure-turtle.core :refer :all] ))

                (defn ikkuna []
                   (new-window {:size [920 900]}))
                   
                 (defn nelio []
                    (forward 100))
