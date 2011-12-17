(ns geolocation.api
  (:use [clojure.data.json :as json]
        [clj-http.client :as http]))

(declare ^:dynamic *email*)
(declare ^:dynamic *password*)
(defn geobytes! [email pwd]
  (def ^:dynamic *email* email)
  (def ^:dynamic *pwd* pwd))

(defn find-me
  "Returns a hash-map with the latitude, longitude, and city
   associated with the IP address of the current host."
  []
  (:geobytes
   (json/read-json
    (:body
     (http/get "http://www.geobytes.com/IpLocator.htm"
               {:query-params {"GetLocation" true
                               "template" "json.txt"
                               "pt_email" *email*
                               "pt_password" *password*}})))))
