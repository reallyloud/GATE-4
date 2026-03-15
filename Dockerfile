FROM gradle:8.5-jdk25
COPY . /java
WORKDIR /java
RUN gradle build --no-daemon

FROM dhi.io/sapmachine:25-jdk-debian13-dev
EXPOSE 80
CMD [ "java","src/Main.java" ]
