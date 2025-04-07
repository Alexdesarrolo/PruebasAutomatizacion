#  Pruebas de Integración - API de Estudiantes

Este proyecto contiene pruebas de integración para una API REST de gestión de estudiantes usando **Spring Boot** .

---

## Qué se prueba?

Se realizaron pruebas de integración para los siguientes endpoints:

| Método | Endpoint               | Descripción                  |
|--------|------------------------|------------------------------|
| POST   | `/estudiantes`         | Crear un nuevo estudiante    |
| GET    | `/estudiantes/{id}`    | Obtener un estudiante por ID |
| DELETE | `/estudiantes/{id}`    | Eliminar un estudiante por ID |

## Cómo ejecutar las pruebas?
- Clona el proyecto
En la carpeta raíz del proyecto usa el coamando: mvn test

## Requisitos
- Java 17 o superior
- Maven
- Spring Boot
