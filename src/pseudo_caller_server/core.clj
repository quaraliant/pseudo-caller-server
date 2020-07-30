(ns pseudo-caller-server.core
  (:require [org.httpkit.server :as server]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer :all]
            [clojure.string :as str]

            [pseudo-caller-server.routes :as routes])
  (:import [com.twilio Twilio])
  (:gen-class))

(defn twilio-init []
  (let [account-sid (System/getenv "TWILIO_SID")
        auth-token (System/getenv "TWILIO_AUTH_TOKEN")]
    (Twilio/init account-sid auth-token)))

(defn -main
  "This is our main entry point"
  [& args]
  (let [port (Integer/parseInt (or (System/getenv "PORT") "3000"))]
    ; Run the server with Ring.defaults middleware
    (twilio-init)
    (server/run-server (wrap-defaults #'routes/app-routes api-defaults) {:port port})
    (println (str "Running webserver at http:/127.0.0.1:" port "/"))))
