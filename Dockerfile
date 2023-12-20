FROM ubuntu:latest AS build

RUN apt-get update
COPY . .

RUN apt-get install maven -y
RUN #mvn clean install

FROM openjdk:20

EXPOSE 8080

COPY --from=build /target/*.jar app.jar

ENTRYPOINT [ "java", "-Dspring.profiles.active=prod", "-jar", "app.jar" ]

