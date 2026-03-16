FROM gradle:9.3.1-jdk25 AS builder
COPY . /java
WORKDIR /java
RUN ./gradlew :spotlessApply && ./gradlew build --no-daemon

FROM dhi.io/sapmachine:25-jdk-debian13-dev
COPY --from=builder /java/build/libs/*.jar /demo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENV SPRING_PROFILES_ACTIVE=docker
CMD [ "java", "-jar", "/demo-0.0.1-SNAPSHOT.jar" ]