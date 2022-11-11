
# 1. Git commands after creating Reagent application

  `git init`

  `git add .`

  `git commit -m "my first commit"`


# 2. Before making a HTTP -requesting function

In your project.clj -file, add this after line 15:

  `[cljs-http "0.1.46"]`


In the core.cljs -file, add these to the requirements, after line 5:

  `[cljs-http.client :as http]`

  `[clojure.core.async :refer [<! go]]`



In the env/dev/clj/<project name>/middleware.cjl -file, add these as last requirements (watch the brackets!)

  `[reitit.ring.middleware.muuntaja :as muuntaja]`

  `[reitit.ring.middleware.parameters :as parameters]`

  `[muuntaja.core :as m]`



In the env/dev/clj/<project name>/middleware.cjl -file, delete the middleware-function, and add these:

  ````
  (def middleware
    [#(wrap-defaults % (assoc-in site-defaults [:security :anti-forgery] false))
    wrap-exceptions
    wrap-reload])

  (def ring-opts
    {:data
    {:muuntaja m/instance
      :middleware [parameters/parameters-middleware
                    muuntaja/format-middleware]}})
  ````

