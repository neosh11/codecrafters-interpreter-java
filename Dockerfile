FROM arm64v8/maven:3.9-eclipse-temurin-23-alpine as build
WORKDIR /app

# Copy only the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:resolve

COPY . .
RUN mvn -B package -Ddir=/app/codecrafters-build-interpreter-java

FROM arm64v8/openjdk:23-jdk-slim
WORKDIR /app
COPY --from=build /app/codecrafters-build-interpreter-java/codecrafters-interpreter.jar /app/codecrafters-interpreter.jar
COPY --from=build /app/test /app/test

ENTRYPOINT ["java", "-jar", "/app/codecrafters-interpreter.jar"]
