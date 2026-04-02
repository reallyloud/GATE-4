FROM gradle:9.3.1-jdk25 AS dependencies
WORKDIR /app
COPY . .
RUN ./gradlew dependencies --no-daemon

FROM dependencies AS builder
WORKDIR /app
COPY src/main ./src/main
COPY src/main/resources ./src/main/resources
COPY /entrypoint.sh .
RUN ./gradlew bootJar --no-daemon

FROM eclipse-temurin:25-jre-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
COPY /entrypoint.sh /entrypoint.sh
EXPOSE 8080
ENV SPRING_PROFILES_ACTIVE=docker
RUN chmod +x /entrypoint.sh
ENTRYPOINT [ "/entrypoint.sh" ]