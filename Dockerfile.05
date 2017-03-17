FROM openjdk:8-jdk-alpine

RUN apk --no-cache --update add bash curl wget ca-certificates && rm -rf /var/cache/apk/*

ENV PATH $PATH:/usr/lib/jvm/java-1.8-openjdk/jre/bin:/usr/lib/jvm/java-1.8-openjdk/bin
ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk
ENV SBT_VERSION 0.13.13
ENV SBT_HOME /usr/share/sbt

ENV SBT_VERSION=0.13.13 \
  SBT_HOME=/usr/share/sbt

ENV PATH=${PATH}:${SBT_HOME}/bin

ADD ./pkg/sbt-0.13.13.tgz /tmp/sbt

RUN mv /tmp/sbt/sbt-launcher-packaging-0.13.13 $SBT_HOME && \
  ln -s $SBT_HOME/bin/* /usr/bin/

WORKDIR /src/app

ADD ./example-apps/echo /src/app

RUN cd /src/app && sbt assembly && \
  cp /src/app/target/scala-2.12/echo.jar /src/app/echo.jar && \
  sbt clean clean-files

EXPOSE 7777

ENTRYPOINT ["java", "-Dconfig.resource=docker.conf", "-jar", "/src/app/echo.jar"]
