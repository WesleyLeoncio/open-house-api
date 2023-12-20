FROM openjdk:20
RUN mkdir /app
WORKDIR /app

RUN apt-get install maven -y
RUN mvn clean install

COPY --from=build /target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-Dspring.profiles.active=prod", "-jar", "app.jar" ]

LABEL authors="Wesley"

#
#FROM ubuntu:latest AS build
#
#RUN apt-get update
#RUN apt-get install openjdk-20-jdk -y
#COPY . .
#
#RUN apt-get install maven -y
#RUN mvn clean install
#
#FROM openjdk:20-ea-jdk-slim
#
#EXPOSE 8080
#
#COPY --from=build /target/*.jar app.jar
#
#ENTRYPOINT [ "java", "-Dspring.profiles.active=prod", "-jar", "app.jar" ]
#
