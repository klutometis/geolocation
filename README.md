# geolocation

Geolocation library for things like IP->city lookup.

# Usage

Add this to your project.clj:

    [facts/geolocation "1.0.0"]

Add to your ns:

    (:use [geolocation.api :as geo])

Get your geolocation:

    (geo/find-me)
