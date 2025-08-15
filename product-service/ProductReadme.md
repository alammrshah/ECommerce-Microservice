# Product Service - Microservices by Bits and Bytes

## Overview

The Product Service is a Spring Boot microservice that manages product data in a microservices architecture. It exposes RESTful APIs for CRUD operations on products and is designed for easy integration with an API Gateway and other services.

---

## Features

- Full CRUD (Create, Read, Update, Delete) for products
- RESTful API endpoints with JSON payloads
- Database integration (H2 for dev, MySQL/PostgreSQL for prod)
- Exception handling and validation
- OpenAPI/Swagger documentation
- Easy integration with API Gateway
- Container-ready (Docker support)
- Unit and integration tests

---

## Technology Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- Spring Web
- H2 / MySQL / PostgreSQL
- Maven
- Lombok (optional)
- Swagger/OpenAPI (for API docs)
- JUnit, Mockito (for testing)
- Docker (optional)

---

## API Endpoints

| Method | Endpoint         | Description                | Request Body         | Response         |
|--------|------------------|----------------------------|----------------------|------------------|
| GET    | /products        | Get all products           | -                    | List\<Product\>  |
| GET    | /products/{id}   | Get product by ID          | -                    | Product          |
| POST   | /products        | Create a new product       | ProductCreateRequest | Product          |
| PUT    | /products/{id}   | Update an existing product | ProductUpdateRequest | Product          |
| DELETE | /products/{id}   | Delete a product           | -                    | void             |

### Example Product JSON

```json
{
  "id": 1,
  "name": "Laptop",
  "description": "High performance laptop",
  "price": 1200.00
}