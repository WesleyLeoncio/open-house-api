
#FROM maven:3.8.7-eclipse-temurin-19-alpine
FROM maven:3.9.1-eclipse-temurin-20-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the source code to the container
COPY . .

# Build the application with Maven
RUN mvn package


# Expose default Spring Boot port
EXPOSE 8080


ENTRYPOINT [ "java", "-jar", "app.jar"]

