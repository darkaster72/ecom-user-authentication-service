FROM openjdk:21-jdk
LABEL authors="darkaster"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]