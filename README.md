# API Backend — Gestión de Usuarios y Personas · Tecsup

API REST desarrollada en **Spring Boot 4 + JPA + PostgreSQL** con CRUD completo de **Usuarios** y **Personas**.

---

## Entidades disponibles

| Entidad | Tabla BD | Endpoints base |
|---|---|---|
| `Usuario` | `usuarios` | `/api/usuarios` |
| `Persona` | `personas` | `/api/personas` |

---

## Endpoints — Usuarios

| Método | Ruta | Descripción | Respuesta OK |
|---|---|---|---|
| `GET` | `/api/usuarios` | Listar todos los usuarios | `200` + array JSON |
| `GET` | `/api/usuarios/{id}` | Obtener usuario por ID | `200` + objeto JSON |
| `POST` | `/api/usuarios` | Crear nuevo usuario | `201` + mensaje |
| `PUT` | `/api/usuarios/{id}` | Actualizar usuario | `200` + mensaje |
| `DELETE` | `/api/usuarios/{id}` | Eliminar usuario | `200` + mensaje |

### Body para `POST` y `PUT` — Usuario
```json
{
  "nombre":     "Juan",
  "apellido":   "Pérez",
  "email":      "juan.perez@gmail.com",
  "contrasena": "Clave123",
  "telefono":   "987654321",
  "activo":     true
}
```

---

## Endpoints — Personas

| Método | Ruta | Descripción | Respuesta OK |
|---|---|---|---|
| `GET` | `/api/personas` | Listar todas las personas | `200` + array JSON |
| `GET` | `/api/personas/{id}` | Obtener persona por ID | `200` + objeto JSON |
| `POST` | `/api/personas` | Crear nueva persona | `201` + mensaje |
| `PUT` | `/api/personas/{id}` | Actualizar persona | `200` + mensaje |
| `DELETE` | `/api/personas/{id}` | Eliminar persona | `200` + mensaje |

### Body para `POST` y `PUT` — Persona
```json
{
  "nombre":    "Ana",
  "apellido":  "García",
  "dni":       "12345678",
  "email":     "ana.garcia@gmail.com",
  "telefono":  "987654321",
  "direccion": "Av. Arequipa 123, Lima",
  "activo":    true
}
```

---

## Arquitectura del proyecto

```
src/main/java/com/usuario/ExamenFinalTecsup/
├── config/
│   └── CorsConfig.java
├── controlador/
│   ├── UsuarioControlador.java
│   └── PersonaControlador.java
├── entidad/
│   ├── Usuario.java
│   └── Persona.java
├── persistencia/
│   ├── IUsuarioDAO.java
│   ├── IPersonaDAO.java
│   └── Implementacion/
│       ├── UsuarioImplementacion.java
│       └── PersonaImplementacion.java
├── repositorio/
│   ├── UsuarioRepositorio.java
│   └── PersonaRepositorio.java
└── servicio/
    ├── IUsuarioServicio.java
    ├── IPersonaServicio.java
    └── Implementacion/
        ├── UsuarioImplementacionServicio.java
        └── PersonaImplementacionServicio.java
```

---

## Configuración de base de datos

### Con Neon (cloud) — `application.properties` actual
```properties
spring.application.name=ExamenFinalTecsup
server.port=8081

spring.datasource.url=jdbc:postgresql://ep-nameless-leaf-aqvamsi6.c-8.us-east-1.aws.neon.tech/neondb?sslmode=require
spring.datasource.username=neondb_owner
spring.datasource.password=npg_4YruoNxjtS1e
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### Con Docker local (alternativa)
```yaml
# docker-compose.yml
services:
  postgres:
    image: postgres:16-alpine
    container_name: tecsup-postgres
    environment:
      POSTGRES_DB: tecsupdb
      POSTGRES_USER: tecsup
      POSTGRES_PASSWORD: tecsup123
    ports:
      - "5432:5432"
    volumes:
      - tecsup_data:/var/lib/postgresql/data

volumes:
  tecsup_data:
```

```properties
# application.properties para Docker local
spring.datasource.url=jdbc:postgresql://localhost:5432/tecsupdb
spring.datasource.username=tecsup
spring.datasource.password=tecsup123
```

---

## Configuración CORS

Permite conexión desde el frontend React en `localhost:5173`:

```java
registry.addMapping("/api/**")
    .allowedOrigins("http://localhost:5173", "http://localhost:4173")
    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
    .allowedHeaders("*");
```

---

## Cómo levantar el proyecto

### Requisitos
- Java 21
- Maven 3.9+

### Pasos

```bash
# 1. Compilar
mvn clean package -DskipTests

# 2. Ejecutar
java -jar target/ExamenFinalTecsup-0.0.1-SNAPSHOT.jar
```

La API queda disponible en:
- `http://localhost:8081/api/usuarios`
- `http://localhost:8081/api/personas`

---

## Repositorios relacionados

- Backend: [api-backend-personas-tecsup](https://github.com/Miguel-Sanchez241001/api-backend-personas-tecsup)
- Frontend: [front-personas-tecsup](https://github.com/Miguel-Sanchez241001/front-personas-tecsup)