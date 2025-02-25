FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/config-server-0.0.1.jar
COPY ${JAR_FILE} config-server-0.0.1.jar
ENTRYPOINT ["java","-jar","config-server-0.0.1.jar"]