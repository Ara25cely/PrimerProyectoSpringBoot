# Tarea Spring boot
### Aracely Jacinto Dominguez

Este proyecto tiene los siguientes endpoints

* localhost:8080/people - GET - lista todas las personas de la BD
* localhost:8080/person - POST - Agregar una persona a la BD
* localhost:8080/address/{userId} - GET - obtiene la direccion asociada a una persona
* localhost:8080/address/{userId} - POST - agrega una direccion asociada a una persona
* localhost:8080/address/{userId} - PUT - actualiza la direccion asociada a una persona

### Instrucciones
* Para poder ejecutar el proyecto se debe de tener instalado postgres y una base de datos llamada Expenses
* Se debe de modificar el archivo de application.properties para agregar las credenciales de la base de datos
* Sincronizar el proyecto (rebuild project) para descargar las dependencias de gradle
* Ejecutar el proyecto usando ./gradlew bootRun o en caso de ser intellij solo ejecutar el archivo ExpensesApplication