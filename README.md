#  Pruebas de Integración - API de Estudiantes

Este proyecto incluye pruebas automatizadas para verificar que los endpoints del API funcionan correctamente. Estas pruebas aseguran que la lógica implementada cumpla con lo esperado y que el sistema sea estable ante posibles cambios futuros.

# ¿Para qué sirven las pruebas?
Las pruebas permiten:

Validar que los datos se están guardando y recuperando correctamente.

Confirmar que los errores se manejan de forma adecuada.

Detectar fallas antes de hacer despliegues o cambios en producción.

Automatizar la verificación del comportamiento del sistema.

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
