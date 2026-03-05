# Spring Boot Backend Template

Reusable REST API template built with:

- Spring Boot 3.3
- Spring Data JPA
- Pageable & Sorting
- DTO Layer
- Global Exception Handling
- Validation
- OpenAPI (Swagger)
- MariaDB

---

## Architecture

Controller → Service → Repository → Database

DTO layer separates API contracts from entities.

---

## Features

✔ CRUD operations  
✔ Pagination  
✔ Sorting  
✔ Dynamic filtering  
✔ Swagger documentation  
✔ Clean layered architecture  

---

## Run locally

1. Configure database in `application.properties`
2. Run the application
3. Access Swagger:

http://localhost:8080/swagger-ui/index.html

---

## Example Pagination

GET /productos?page=0&size=5&sort=precio,desc

---

## How to reuse this template

1. Clone repository
2. Rename base package
3. Replace `Producto` entity
4. Adapt DTOs
5. Add new endpoints

---

## Future Improvements

- JWT Security
- Docker support
- CI/CD
- Testing layer
