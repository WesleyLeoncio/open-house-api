FROM maven:3.9-amazoncorretto-8-al2023 as build
WORKDIR /app
COPY . .
RUN mvn clean package

FROM openjdk:20-ea-jdk-slim
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar
ENTRYPOINT [ "java", "-Dspring.profiles.active=prod", "-jar", "app.jar" ]




