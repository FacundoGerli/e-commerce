FROM openjdk:23
ARG JAR_FILE=target/eureka-server-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} eureka-server
ENTRYPOINT ["java","-jar","eureka-server"]