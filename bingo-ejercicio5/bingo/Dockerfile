FROM ubuntu

# Install Java 11
RUN apt-get update && apt-get install -y openjdk-11-jdk

# Set the working directory
WORKDIR /app

# Copy the application files
COPY . /app

# Run the application
CMD ["java", "-jar", "myapp.jar"]