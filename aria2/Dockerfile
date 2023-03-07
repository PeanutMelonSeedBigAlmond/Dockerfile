FROM alpine

ENV ARIA2_VERSION=1.36.0

RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/' /etc/apk/repositories && \
    apk add aria2 && mkdir -m 777 /config /downloads

VOLUME [ "/downloads" ]
ENTRYPOINT [ "aria2c" ]
CMD [ "--conf-path","/config/aria2.conf" ]
