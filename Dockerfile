
#FROM maven:3.8.7-eclipse-temurin-19-alpine
FROM maven:3.9.2-eclipse-temurin-20-alpine AS build
COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:20-ea-1-jdk-slim
COPY  --from=build /target/open-house-api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080


ENTRYPOINT [ "java","-Dspring.profiles.active=prod", "-DDATASOURCE_URL=jdbc:dpg-cm1k78la73kc73fj0qv0-a.oregon-postgres.render.com", "-DDATASOURCE_USERNAME=open_house_user", "-DDATASOURCE_PASSWORD=DnWawWXK83nQAyJd4TyXynQkH2CJphfF","-jar","app.jar"]

