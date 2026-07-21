# Spring Data JPA: Consultas complejas sin `@Query`

Proyecto de demostración para una píldora técnica sobre cómo construir consultas dinámicas en Spring Data JPA utilizando **Specifications**, evitando el uso de `@Query` para escenarios de filtrado flexible.

## Objetivo

Mostrar cómo:

* Utilizar Query Methods para consultas simples.
* Escalar a consultas dinámicas mediante `Specification`.
* Combinar filtros de forma reutilizable y mantenible.
* Mantener el código limpio separando la lógica de búsqueda del servicio.

## Tecnologías utilizadas

* Java 21
* Spring Boot
* Spring Data JPA
* H2 Database
* Lombok

## Estructura del proyecto

```text
src/main/java
├── controller
│   └── ArticleController
├── entity
│   └── Article
├── repository
│   └── ArticleRepository
│   └── specification
│     └── ArticleSpecification
├── service
   └── ArticleService

```

## Ejecución

1. Clonar el repositorio.
2. Ejecutar la aplicación Spring Boot.
3. Acceder a la consola H2:

```text
http://localhost:8080/h2-console
```

Configuración:

```text
JDBC URL: jdbc:h2:mem:testdb
User: sa
Password:
```

## Endpoints de prueba

Obtener artículos filtrados:

```text
GET /articles/search
```

Ejemplos:

```text
/articles/search?status=PUBLISHED
```

```text
/articles/search?category=Backend
```

```text
/articles/search?status=PUBLISHED&category=Backend
```

```text
/articles/search?status=PUBLISHED&category=Backend&author=Anna
```

## Concepto principal

Cada filtro se implementa como una `Specification` independiente y reutilizable:

```java
hasStatus()
hasCategory()
hasAuthor()
```

Estas Specifications se combinan dinámicamente según los parámetros recibidos en la petición.

## Autora

Aïda García
Píldora técnica – FemCoders
