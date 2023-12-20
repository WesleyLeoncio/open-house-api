FROM maven:3.9-amazoncorretto-8-al2023 as build
WORKDIR /app
COPY . .
RUN mvn clean package -X -DskipTests

FROM openjdk:20-ea-jdk-slim
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar
ENTRYPOINT [ "java", "-jar", "-Dspring.profiles.active=prod", "app.jar" ]




