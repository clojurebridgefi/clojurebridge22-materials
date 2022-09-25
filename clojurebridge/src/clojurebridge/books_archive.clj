(ns clojurebridge.books-archive)

;;
;; Books (sources: goodreads.com and piki.verkkokirjasto.fi)
;;

(def books [{:name "The Essex Serpent"
             :author "Sarah Perry"
             :pages 422
             :genre :romance
             :rating 3.56}
            {:name "Kivitasku"
             :author "Anni Kytömäki"
             :pages 645
             :genre :romance
             :rating 4.24}
            {:name "Assassin's Apprentice"
             :author "Robin Hobb"
             :pages 435
             :genre :fantasy
             :rating 4.17}
            {:name "Lean Software Development"
             :author "Mary Poppendieck"
             :pages 276
             :genre :programming
             :rating 4.2}
            {:name "Veriruusut"
             :author "Anneli Kanto"
             :pages 427
             :genre :historical
             :rating 4.24}
            {:name "A Wizard of Earthsea"
             :author "Ursula K. Le Guin"
             :pages 183
             :genre :fantasy
             :rating 4.0}
            {:name "The Left Hand of Darkness"
             :author "Ursula K. Le Guin"
             :pages 304
             :genre :sci-fi
             :rating 4.09}
            {:name "Chaos"
             :author "Patricia Cornwell"
             :pages 480
             :genre :mystery
             :rating 3.62}
            {:name "Where the Crawdads Sing"
             :author "Delia Owens"
             :pages 384
             :genre :mystery
             :rating 4.44}])

; filter:

; map:

;; reduce:
;; What is the sum of pages of :sci-fi and :fantasy books?

