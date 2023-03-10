FROM maven:3.8.6-openjdk-11-slim AS builder
WORKDIR /app
COPY pom.xml . 
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN maven -e -B package

FROM openjdk:11-jre-slim-buster
COPY --from=bulder /app/target/app.jar
CMD [ "java", "-jar", "/app.jar" ]
