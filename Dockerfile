FROM openjdk:19-jdk-alpine

WORKDIR /app

COPY *.java /app

RUN javac *.java && rm *.java

VOLUME /app/exec.ws

ENTRYPOINT ["java", "Test", "exec.ws"]