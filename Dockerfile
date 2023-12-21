FROM maven:3.9.2-eclipse-temurin-20-alpine AS build
COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:20-ea-1-jdk-slim
#COPY  --from=build /target/open-house-api-0.0.1-SNAPSHOT.jar app.jar
COPY  --from=build /target/*.jar app.jar
EXPOSE 8080


ENTRYPOINT [ "java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]

