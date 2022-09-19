FROM amazoncorretto:11-al2-jdk
ARG JAR_FILE=electronic-bill-application/build/libs/*.jar
COPY ${JAR_FILE} electronic-bill-api_v1.jar
ENTRYPOINT ["java", "-jar", "electronic-bill-api_v1.jar"]