
#FROM maven:3.8.7-eclipse-temurin-19-alpine
FROM maven:3.9.1-eclipse-temurin-20-alpine
WORKDIR /app
COPY . .
RUN mvn package

ENV DATASOURCE_URL=dpg-cm1k78la73kc73fj0qv0-a.oregon-postgres.render.com
ENV DATASOURCE_USERNAME=open_house_user
ENV DATASOURCE_PASSWORD=DnWawWXK83nQAyJd4TyXynQkH2CJphfF

EXPOSE 8080


ENTRYPOINT [ "java", "-jar", "target/open-house-api-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=prod"]

