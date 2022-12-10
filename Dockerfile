FROM openjdk:8-jdk-alpine
EXPOSE 8086
ADD ./target/ExamThourayaS2-1.0.jar test-docker.jar
ENTRYPOINT ["java","-jar","/test-docker.jar"]