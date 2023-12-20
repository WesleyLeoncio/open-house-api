FROM maven:3.8-openjdk-17 AS build
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
ADD . /usr/src/app
RUN mvn package

FROM eclipse-temurin:17-jdk
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY --from=build /target/*.jar app.jar

ENTRYPOINT [ "java", "-jar", "-Dspring.profiles.active=prod", "app.jar" ]