(ns pseudo-caller-server.db
  (:require [next.jdbc :as jdbc]
            [next.jdbc.sql :as sql]))

(def db {:dbtype "h2" :dbname "pseudocaller"})
(def ds (jdbc/get-datasource db))

(defn init-db []
  (jdbc/execute! 
   ds 
   ["
    create table lines (
      phone_number varchar(255) primary key,
      sip_domain varchar(255)
    );"]))

(defn insert-phone-line [phone-number sip-domain]
  (sql/insert! 
   ds 
   :lines
   {:phone_number phone-number :sip_domain sip-domain}))
