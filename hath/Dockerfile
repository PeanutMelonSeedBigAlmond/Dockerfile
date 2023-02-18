FROM openjdk:17.0.2

ENV HATH_URL=https://repo.e-hentai.org/hath/HentaiAtHome_1.6.1.zip
ENV TZ=Asia/Shanghai

COPY . /
WORKDIR /
RUN mkdir -m 777 data && \
    curl https://oss.oracle.com/el4/unzip/unzip.tar -o unzip.tar && \
    tar -xf unzip.tar && \
    mv unzip /usr/local/bin/unzip && \
    chmod +x /usr/local/bin/unzip && \
    curl ${HATH_URL} -o hath.zip && \
    unzip hath.zip HentaiAtHome.jar && \
    rm -f hath.zip unzip.tar

VOLUME ["/cache"]

ENTRYPOINT [ "java", "--add-opens", "java.base/java.net=ALL-UNNAMED", "Main.java" ]
