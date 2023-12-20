FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk20:20.0.2_p9-r0 -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk20:20.0.2_p9-r0

EXPOSE 8080

COPY --from=build /target/deploy_render-1.0.0.jar app.jar



ENTRYPOINT [ "java", "-jar", "-Dspring.profiles.active=prod", "app.jar" ]

