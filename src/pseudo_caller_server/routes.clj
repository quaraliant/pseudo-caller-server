(ns pseudo-caller-server.routes
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [pseudo-caller-server.account :as account]))

(defroutes app-routes
  (POST "/lines" [phone-number password] (account/init-phone-line phone-number password))
  (route/not-found "Error, page not found!"))
