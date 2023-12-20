FROM openjdk:20
RUN mkdir /app
WORKDIR /app

COPY target/*.jar /app/app.jar

EXPOSE 8080

COPY --from=build /target/deploy_render-1.0.0.jar app.jar

ENTRYPOINT [ "java", "-Dspring.profiles.active=prod", "-jar", "app.jar" ]


