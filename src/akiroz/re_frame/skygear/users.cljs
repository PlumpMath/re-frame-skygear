(ns akiroz.re-frame.skygear.users
  (:require [cljs.spec :as s]
            [cljsjs.skygear]))

(def skygear js/skygear)

(defn login [{:keys [username password]}]
  (.loginWithUsername skygear username password))

(defn logout [_]
  (.logout skygear))

(defn signup [{:keys [username password]}]
  (.signupWithUsername skygear username password))

(defn passwd [{:keys [old-pass new-pass]}]
  (.changePassword skygear old-pass new-pass))


(s/def ::username string?)
(s/def ::password string?)

(s/def ::old-pass ::password)
(s/def ::new-pass ::password)

(s/def ::login (s/keys :req [::username ::password]))
(s/def ::signup (s/keys :req [::username ::password]))
(s/def ::passwd (s/keys :req [::old-pass ::new-pass]))
(s/def ::logout (fn [_] true))
