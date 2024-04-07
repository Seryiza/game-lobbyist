FROM m1k1o/neko:chromium

RUN apt-get update;\
    apt-get install -y netcat socat

#RUN socat tcp-listen:9223,reuseaddr,fork tcp:localhost:9222 &
