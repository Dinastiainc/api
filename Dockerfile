FROM amazoncorretto:11-alpine
ENV URL_DB jdbc:sqlserver://192.168.0.50:1433;encrypt=true;databaseName=PRUEBAS;schema=dbo;trustServerCertificate=true
ENV USERNAME_DB sirem
ENV PASSWORD_DB sirempruebas
ARG JAR_FILE=electronic-bill-application/build/libs/*.jar
COPY ${JAR_FILE} electronic-bill-api_v1.jar
ENTRYPOINT ["java", "-jar", "electronic-bill-api_v1.jar"]