FROM ubuntu:xenial

ENV DEBIAN_FRONTEND=noninteractive \
  SCALA_VERSION=2.12.1 \
  SCALA_SBT_VERSION=0.13.13 \
  LC_ALL=C.UTF-8 \
  LANG=C.UTF-8 \
  LANGUAGE=C.UTF-8

RUN echo "deb http://ppa.launchpad.net/webupd8team/java/ubuntu xenial main" >> /etc/apt/sources.list.d/webupd8team-ubuntu-java-xenial.list && \
  apt-key adv --keyserver keyserver.ubuntu.com --recv-keys 0xc2518248eea14886 && \
  apt-get -qy update && apt-get -qy upgrade

RUN echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections

RUN apt-get install -qy oracle-java8-installer && \
  wget http://downloads.lightbend.com/scala/${SCALA_VERSION}/scala-${SCALA_VERSION}.deb -O /tmp/scala-${SCALA_VERSION}.deb && \
  dpkg -i /tmp/scala-${SCALA_VERSION}.deb && \
  wget https://dl.bintray.com/sbt/debian/sbt-${SCALA_SBT_VERSION}.deb -O /tmp/sbt-${SCALA_SBT_VERSION}.deb && \
  dpkg -i /tmp/sbt-${SCALA_SBT_VERSION}.deb && \
  apt-get -y clean && apt-get -y autoclean && rm -f /tmp/*.deb && rm -rf /var/lib/apt/lists/* && \
  rm -rf /usr/share/doc*

ENV JAVA_HOME=/usr/lib/jvm/java-8-oracle \
  SCALA_HOME=/usr/share/scala

RUN update-alternatives --install "/usr/bin/java" "java" "/usr/lib/jvm/java-8-oracle/bin/java" 1081 && \
  update-alternatives --install "/usr/bin/javac" "javac" "/usr/lib/jvm/java-8-oracle/bin/javac" 1081 && \
  update-alternatives --install "/usr/bin/javaws" "javaws" "/usr/lib/jvm/java-8-oracle/bin/javaws" 1081 && \
  mkdir -p /src/app

RUN apt-get clean && apt-get purge -y --auto-remove && \
  rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

WORKDIR /src/app

ADD ./example-apps/echo /src/app

RUN cd /src/app && sbt assembly && \
  cp /src/app/target/scala-2.12/echo.jar /src/app/echo.jar && \
  sbt clean clean-files

EXPOSE 7777

ENTRYPOINT ["java", "-Dconfig.resource=docker.conf", "-jar", "/src/app/echo.jar"]
