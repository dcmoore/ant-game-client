(defproject ascent-api "0.1.0-SNAPSHOT"
  :description "API to the Ascent project"
  :url "http://ascent-api.8thlight.com"
  :min-lein-version "2.0.0"
  :dependencies [[compojure "1.3.1"]
                 [info.sunng/ring-jetty9-adapter "0.9.1"]
                 [org.clojure/clojure "1.6.0"]
                 [ring/ring-defaults "0.1.2"]]
  :plugins [[com.github.metaphor/lein-flyway "1.0"]]
  :aliases {"autotest" ["with-profile" "test" "auto" "test"]
            "test" ["with-profile" "test" "test"]}
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]]
                   :main ascent-api.handler
                   :aot [ascent-api.handler]}
             :test {:dependencies [[ring-mock "0.1.5"]]
                    :plugins [[lein-auto "0.1.2"]]}})
