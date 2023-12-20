FROM openjdk:20
RUN mkdir /app
WORKDIR /app

COPY target/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-Dspring.profiles.active=prod", "-jar", "app.jar" ]

LABEL authors="Wesley"




