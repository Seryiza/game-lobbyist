(ns gamelobbyist.browser
  (:require [etaoin.api :as e]
            [clj-chrome-devtools.core :as core]
            [clj-chrome-devtools.automation :as auto]
            [clojure.string :as str]))

(comment
  (def cbrower (core/connect "localhost" 9222))
  (def autobrowser (auto/create-automation cbrower))
  (auto/to autobrowser "https://vc.ru"))
