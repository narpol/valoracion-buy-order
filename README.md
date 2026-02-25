# Proyecto de valoración tecnica

## JDK 17
## Database Postgresql
### Database name buy-order


# Microservicio de Órdenes - Arquitectura Hexagonal (Java 17 + Spring Boot)

## Descripción

Este proyecto implementa un microservicio para la gestión de órdenes de compra aplicando **Arquitectura Hexagonal (Ports & Adapters)**, principios **SOLID** y buenas prácticas de **Clean Code**.  
El sistema permite:

- Crear una orden
- Confirmar una orden
- Cancelar una orden
- Consultar una orden por id

Las reglas de negocio se encuentran completamente desacopladas de la infraestructura.

---

## Arquitectura Hexagonal Aplicada

Se implementó una separación clara entre:

### Dominio
Contiene la lógica de negocio pura sin dependencias de frameworks:

- Entidades (`Order`, `Product`)
- Reglas de negocio
- Enum de estado
- UseCases
- Puertos (`OrderGateway`)

El dominio es independiente de Spring y JPA.

---

### Puertos (Ports)

Se definieron interfaces para desacoplar el dominio de la infraestructura:

- `OrderGateway` → Abstracción para persistencia de órdenes.

Esto permite cambiar la tecnología de acceso a datos sin afectar el dominio.

---

### Adaptadores (Adapters)

#### Driven Adapter (Infraestructura - Persistencia)
Implementado con:

- Spring Data JPA
- Entidades `DBO`
- Mapper Domain ↔ Entity

Responsable únicamente de la persistencia.

---

#### Entry Points (API REST)
Contiene:

- Controllers
- DTOs
- Conversión DTO ↔ Domain

Se encarga solo del transporte HTTP.

---

## Aplicación de Principios SOLID

### Single Responsibility
Cada capa tiene una única responsabilidad:

- Dominio → reglas de negocio  
- UseCase → orquestación  
- Adapter → infraestructura  
- Controller → transporte HTTP  

---

### Open/Closed
El sistema permite extender adaptadores sin modificar el dominio.

---

### Liskov Substitution
El dominio depende de interfaces (`OrderGateway`), permitiendo reemplazar implementaciones.

---

### Interface Segregation
El puerto define únicamente los métodos necesarios para la lógica de órdenes.

---

### Dependency Inversion
El dominio depende de abstracciones, no de frameworks.

---

## Reglas de Negocio Implementadas

- Una orden debe tener al menos un producto.
- El total se calcula automáticamente.
- El estado inicial es **CREATED**.
- Solo órdenes en estado **CREATED** pueden:
  - Confirmarse
  - Cancelarse
- El estado se protege dentro de la entidad.

---

## Decisiones de Diseño

- Se utilizó **Arquitectura Hexagonal** para desacoplar dominio e infraestructura.
- Se implementaron **mappers** para evitar dependencias entre capas.
- Se evitó el uso de anotaciones JPA en el dominio.
- Se encapsularon las transiciones de estado dentro de la entidad `Order`.
- Se utilizaron DTOs para aislar la capa HTTP.

---

