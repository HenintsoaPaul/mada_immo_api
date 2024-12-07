# Stage 1: Build the application
FROM openjdk:17-jdk-slim as builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/mada_immo-unos.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

