# Use Eclipse Temurin official Java 21 image
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy the built jar from your project to the image
COPY target/your-app.jar app.jar

# Expose port (adjust if your Spring Boot runs on a different port)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
