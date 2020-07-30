(ns pseudo-caller-server.account
  (:require [pseudo-caller-server.db :as db])
  (:import [com.twilio.rest.api.v2010.account.sip Domain]))

(defn create-sip-domain [uuid]
  (println (.create (Domain/creator uuid))))

(defn create-sip-credential [sip-domain phone-number password])

(defn init-phone-line [phone-number password]
  (let [sip-domain-name (java.util.UUID/randomUUID)]
    (db/insert-phone-line sip-domain-name phone-number)
    (create-sip-domain sip-domain-name)
    (create-sip-credential sip-domain-name phone-number password)
    true))
