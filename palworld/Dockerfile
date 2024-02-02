FROM cm2network/steamcmd
ENV FORCE_UPDATE=false
ENV ENABLE_MULTITHREAD=false
ENV GAME_PORT=8211
ENV RCON_ENABLED=false
ENV ENABLE_MULTITHREAD=true
ENV ADMIN_PASSWORD=changeme
ENV SERVER_NAME="Default Palworld Server"
ENV SERVER_DESC=
ENV SERVER_PASSWORD=
ENV RCON_PORT=25575
ENV IS_PUBLIC=false
ENV PUBLIC_IP=
ENV PUBLIC_PORT=

COPY docker-entrypoint.sh /docker-entrypoint.sh

USER root
RUN mkdir /opt/palworld && chown steam:steam /opt/palworld

USER steam
WORKDIR /opt/palworld
RUN /home/steam/steamcmd/steamcmd.sh +force_install_dir "/opt/palworld" +login anonymous +app_update 2394010 validate +quit

VOLUME "/opt/palworld/Pal/Saved"
ENTRYPOINT ["/bin/bash","/docker-entrypoint.sh"]
