FROM openjdk:21
ARG JAR_FILE=target/policy-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} policy.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/policy.jar"]