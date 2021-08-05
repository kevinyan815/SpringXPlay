FROM openjdk:8-jre
ARG JAR_FILE
ADD target/${JAR_FILE} /application.jar
ENTRYPOINT ["java", "-jar","/application.jar"]