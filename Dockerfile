# Use Maven to build the app
FROM maven:3.9.6-eclipse-temurin-21 AS builder

# Set working directory
WORKDIR /app

# Copy Maven project files
COPY pom.xml .
COPY src ./src

# Build the application (skip tests for faster build)
RUN mvn clean package -DskipTests

# Use a lightweight JDK for runtime
FROM eclipse-temurin:21-jdk

# Set working directory for runtime
WORKDIR /app

# Copy the jar file from builder stage
COPY --from=builder /app/target/*.jar springboot-image.jar

# Expose application port (change if needed)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "springboot-image.jar"]
