FROM phenompeople/openjdk20:vulnerablescan AS build
RUN mkdir /app
WORKDIR /app
ADD . /app
RUN mvn package

FROM eclipse-temurin:20-jdk
RUN mkdir /app
WORKDIR /app
COPY --from=build /target/*.jar app.jar

ENTRYPOINT [ "java", "-jar", "-Dspring.profiles.active=prod", "app.jar" ]

