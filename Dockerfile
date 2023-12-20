#FROM ubuntu:latest AS build
#
#RUN apt-get update
#COPY . .
#
#RUN apt-get install maven -y
#RUN #mvn clean install
#
#FROM openjdk:20
#
#EXPOSE 8080
#
#COPY --from=build /target/*.jar app.jar
FROM eclipse-temurin:20-jdk-jammy as builder
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install

FROM eclipse-temurin:20-jre-jammy
WORKDIR /opt/app
EXPOSE 8080
COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar


ENTRYPOINT [ "java", "-Dspring.profiles.active=prod", "-jar", "app.jar" ]

