FROM openjdk:20
RUN mkdir /app
WORKDIR /app
RUN mvn clean install


COPY target/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "app.jar" ]

LABEL authors="Wesley"
