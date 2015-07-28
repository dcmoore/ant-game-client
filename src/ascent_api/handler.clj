(ns ascent-api.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.adapter.jetty9 :refer [run-jetty]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]])
  (:gen-class))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (route/not-found "Not Found"))

(def app
  (->
    app-routes
    (wrap-defaults api-defaults)))

(def http-handler run-jetty)

(defn -main [& args]
  (let [port (Integer/parseInt (or (first args) "4040"))]
    (http-handler app {:port port})))
