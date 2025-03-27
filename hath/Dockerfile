FROM alpine as build

ARG hathVersion=1.6.2
ENV HATH_URL=https://repo.e-hentai.org/hath/HentaiAtHome_${hathVersion}.zip
WORKDIR /

RUN apk add --no-cache wget unzip && \
    wget ${HATH_URL} -O hath.zip && \
    unzip hath.zip HentaiAtHome.jar

FROM openjdk:21-slim-bookworm as release

ARG hathVersion=1.6.2
ENV HATH_URL=https://repo.e-hentai.org/hath/HentaiAtHome_${hathVersion}.zip
ENV TZ=Asia/Shanghai

COPY --from=build /HentaiAtHome.jar /HentaiAtHome.jar
WORKDIR /
ADD Main.java Main
RUN mkdir -m 777 data && \
    chmod +x /Main

VOLUME ["/cache"]

ENTRYPOINT ["/Main"]
