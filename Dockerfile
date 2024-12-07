# Use a base image with JDK
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy the Spring Boot jar file
COPY target/mada_immo-unos.jar app.jar

# Expose the port the application will run on
EXPOSE 911

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
