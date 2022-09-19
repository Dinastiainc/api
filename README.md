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
