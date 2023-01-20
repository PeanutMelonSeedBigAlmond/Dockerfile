FROM golang as build-clash
WORKDIR /app
RUN git clone https://github.com/Dreamacro/clash.git /app --depth 1 --recursive && \
    make
 

FROM node as build-dashboard
WORKDIR /app
RUN git clone https://github.com/Dreamacro/clash-dashboard.git /app --depth 1 --recursive && \
    npm config set registry https://registry.npm.taobao.org/ && \
    npm install -g pnpm && \
    pnpm install && \
    pnpm build


FROM alpine as production

WORKDIR /app

COPY --from=build-clash /app/bin/clash-linux-amd64 /usr/local/bin/clash
COPY --from=build-dashboard /app/dist /app/clash-dashboard

RUN apk add wget && \
    wget -O Country.mmdb https://cdn.jsdelivr.net/gh/Loyalsoldier/geoip@release/Country.mmdb

ENTRYPOINT [ "clash" ]
CMD [ "-d", "/app" ]
