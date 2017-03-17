FROM openjdk:8-jre-alpine

RUN mkdir -p /src/app

ADD ./pkg/echo.jar /src/app

WORKDIR /src/app

EXPOSE 7777

ENTRYPOINT ["java", "-Dconfig.resource=docker.conf", "-jar", "/src/app/echo.jar"]
