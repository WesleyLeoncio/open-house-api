
#FROM maven:3.8.7-eclipse-temurin-19-alpine
FROM maven:3.9.2-eclipse-temurin-20-alpine
WORKDIR /app
COPY . .

RUN mvn package


EXPOSE 8080


ENTRYPOINT [ "java", "-jar", "app.jar", "-Dspring.profiles.active=prod"]

