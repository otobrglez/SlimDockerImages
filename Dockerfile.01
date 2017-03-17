FROM ubuntu:xenial

ENV DEBIAN_FRONTEND noninteractive
ENV SCALA_VERSION 2.12.1
ENV SCALA_SBT_VERSION 0.13.13
ENV LC_ALL C.UTF-8
ENV LANG C.UTF-8
ENV LANGUAGE C.UTF-8

RUN echo "deb http://ppa.launchpad.net/webupd8team/java/ubuntu xenial main" >> /etc/apt/sources.list.d/webupd8team-ubuntu-java-xenial.list
RUN apt-key adv --keyserver keyserver.ubuntu.com --recv-keys 0xc2518248eea14886

RUN apt-get -qy update
RUN apt-get -qy upgrade

RUN echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections
RUN apt-get install -qy oracle-java8-installer

RUN wget http://downloads.lightbend.com/scala/${SCALA_VERSION}/scala-${SCALA_VERSION}.deb -O /tmp/scala-${SCALA_VERSION}.deb
RUN dpkg -i /tmp/scala-${SCALA_VERSION}.deb

RUN wget https://dl.bintray.com/sbt/debian/sbt-${SCALA_SBT_VERSION}.deb -O /tmp/sbt-${SCALA_SBT_VERSION}.deb
RUN dpkg -i /tmp/sbt-${SCALA_SBT_VERSION}.deb

ENV JAVA_HOME=/usr/lib/jvm/java-8-oracle
ENV SCALA_HOME=/usr/share/scala

RUN update-alternatives --install "/usr/bin/java" "java" "/usr/lib/jvm/java-8-oracle/bin/java" 1081
RUN update-alternatives --install "/usr/bin/javac" "javac" "/usr/lib/jvm/java-8-oracle/bin/javac" 1081
RUN update-alternatives --install "/usr/bin/javaws" "javaws" "/usr/lib/jvm/java-8-oracle/bin/javaws" 1081

RUN mkdir -p /src/app

WORKDIR /src/app

ADD ./example-apps/echo /src/app

RUN cd /src/app
RUN sbt assembly

EXPOSE 7777

ENTRYPOINT ["java", "-Dconfig.resource=docker.conf", "-jar", "/src/app/target/scala-2.12/echo.jar"]
