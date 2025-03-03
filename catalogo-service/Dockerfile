FROM openjdk:23-jdk-slim
ARG JAR_FILE=target/catalogo-service-0.0.1.jar
COPY ${JAR_FILE} catologo-service
ENTRYPOINT ["java","-jar","catologo-service"]