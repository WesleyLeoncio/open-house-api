
#FROM maven:3.8.7-eclipse-temurin-19-alpine
FROM maven:3.9.1-eclipse-temurin-20-alpine AS build
WORKDIR /app
COPY . .
RUN mvn package -X -DskipTests



EXPOSE 8080

COPY --from=build /target/*.jar  app.jar

ENTRYPOINT [ "java", "-jar", "app.jar"]

