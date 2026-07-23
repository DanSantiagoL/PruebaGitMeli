# Workshop Spring Boot

Proyecto de aprendizaje de Spring Boot con Maven y Java 21.

## Stack
- Java 21
- Spring Boot 3.3.0
- Maven
- MySQL (a integrar)

## Estructura del proyecto
- `com.meli.workshop` — paquete raíz
- `controller/` — endpoints REST
- `service/` — lógica de negocio
- `model/` — entidades de dominio
- `dto/` — objetos de transferencia
- `exception/` — excepciones custom y handler global

## Convenciones
- Inyección de dependencias por constructor con campos `final`, sin `@Autowired`.
- Endpoints REST siguen convención plural: `/api/productos`.
- Excepciones custom extienden RuntimeException.
- El controller solo delega al service; no lleva lógica de negocio.
- Idioma en comentarios y mensajes de error: español.

## Comandos útiles
- Correr la app: `mvn spring-boot:run`
- Correr tests: `mvn test`
- Build: `mvn clean package`