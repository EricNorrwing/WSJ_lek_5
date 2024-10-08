# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim
# Set the working directory in the container
WORKDIR /app
# Copy the JAR file into the container named /app and renames it to 'my-spring-app'
COPY build/libs/WSJ_lek_5-0.0.1-SNAPSHOT.jar /app/my-spring-app.jar
# Expose the port that the application will run on (Must reflect Spring Boot's port
EXPOSE 8080
# Command to run the app
ENTRYPOINT ["java", "-jar", "/app/my-spring-app.jar"]
