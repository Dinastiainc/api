# electronic-bill-api 

## port default
El puerto por defecto de la API es 8080

## Generar el artefacto .jar

Para generar el jar se ejecuta la tarea de gradle bootJar, en .jar se guarda en la carpeta
"electronic-bill-api\electronic-bill-application\build\libs" dentro del proyecto

## Generar imagen Docker desde el Docker file

docker build -t <nombre imagen>:<version> <ruta ubicacion Dockerfile (Contexto)>

Ejemplo:
    docker build -t electronic-build-api:v1 .

## Crear el contenedor

docker run -d --name <nombre contenedor> -e ELECTRONIC_BILL_LOG_PATH=/ruta/de/los/logs/ -v /ruta/equipo/anfitrion/:/ruta/de/los/logs/ -p <puerto Salida>:<puerto contenedor>

Ejemplo:
    docker run -d --name electonicBill11 -e ELECTRONIC_BILL_LOG_PATH=/tmp/logs/ -v C:\\tmp\\logs\\:/tmp/logs/  -p 8091:8080 electronic-build-api:v2

edit1. Trigger new deployment.
