FROM openjdk:20
RUN mkdir /app
WORKDIR /app

COPY target/*.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-Dspring.profiles.active=prod", "-DDATASOURCE_URL=jdbc:postgresql://172.18.0.2:5432/open_house", "-DDATASOURCE_USERNAME=postgres", "-DDATASOURCE_PASSWORD=postgres", "-jar", "/app/app.jar"]

LABEL authors="Wesley"
