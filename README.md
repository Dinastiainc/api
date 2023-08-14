# electronic-bill-api 

## port default
El puerto por defecto de la API es 8080

## Generar el artefacto .jar

run command:
./gradlew :electronic-bill-application:bootJar

Para generar el jar se ejecuta la tarea de gradle bootJar, en .jar se guarda en la carpeta
"electronic-bill-api\electronic-bill-application\build\libs" dentro del proyecto

## correr el app en local

java -DUSERNAME_DB=sirem -DPASSWORD_DB=sirempruebas -DELECTRONIC_BILL_LOG_PATH=/tmp/logs/ -DURL_DB="jdbc:sqlserver://192.168.0.50:1433;encrypt=true;databaseName=PRUEBAS;schema=dbo;trustServerCertificate=true" -jar electronic-bill-application/build/libs/electronic-bill-application.jar

If you get the error "The server selected protocol version TLS10 is not accepted by client preferences [TLS13, TLS12]" it probably means the algorithm is disalbed on your version of java. Downgrade to Java 8, or edit the file java.config and jdk.tls.disabledAlgorithms


## Generar imagen Docker desde el Docker file

docker build -t <nombre imagen>:<version> <ruta ubicacion Dockerfile (Contexto)>

Ejemplo:
    docker build -t electronic-build-api:v1 .

## Crear el contenedor

docker run -d --name <nombre contenedor> -e ELECTRONIC_BILL_LOG_PATH=/ruta/de/los/logs/ -v /ruta/equipo/anfitrion/:/ruta/de/los/logs/ -p <puerto Salida>:<puerto contenedor>

Ejemplo:
    docker run -d --name electonicBill11 -e ELECTRONIC_BILL_LOG_PATH=/tmp/logs/ -v C:\\tmp\\logs\\:/tmp/logs/  -p 8091:8080 electronic-build-api:v2