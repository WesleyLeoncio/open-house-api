FROM openjdk:20
COPY . .

COPY --from=build  target/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-Dspring.profiles.active=prod", "-jar", "app.jar" ]



