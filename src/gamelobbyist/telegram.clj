(ns gamelobbyist.telegram
  (:require [cheshire.core :as json]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [org.httpkit.client :as http]))

(def token (System/getenv "TELEGRAM_BOT_TOKEN"))
(def chat-id (System/getenv "TELEGRAM_CHAT_ID"))

(defn api-request [http-method api-method params]
  (let [url (format "https://api.telegram.org/bot%s/%s"
                    token
                    api-method)]
    @(http/request {:url url
                    :method http-method
                    :as :text
                    :headers {"content-type" "application/json"}
                    :body (json/generate-string params)})))

(comment
  (api-request :post "getUpdates" {})
  (api-request :post "sendMessage" {:chat_id chat-id
                                    :text "Hello"
                                    :reply_markup {:inline_keyboard [[{:text "In 1h" :callback_data "1h"}
                                                                      {:text "In 2h" :callback_data "2h"}]

                                                                     [{:text "Forget" :callback_data "forget"}]]}}))
