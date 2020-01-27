FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
WORKDIR /usr/app
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app.jar"]