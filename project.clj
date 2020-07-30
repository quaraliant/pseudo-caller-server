(defproject pseudo-caller-server "0.0.1-SNAPSHOT"
  :description "Server for managing numbers associated with your Twilio accounts"
  :url "https://github.com/quaraliant/pseudo-caller-server"
  :license {:name "GPL v3.0"
            :url "https://www.gnu.org/licenses/gpl-3.0.en.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [com.twilio.sdk/twilio "7.52.0"]
                 [compojure "1.6.1"]
                 [http-kit "2.3.0"]
                 [ring/ring-defaults "0.3.2"]
                 [org.clojure/data.json "1.0.0"]
                 [seancorfield/next.jdbc "1.1.547"]
                 [com.h2database/h2 "1.4.199"]]
  :main ^:skip-aot pseudo-caller-server.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
