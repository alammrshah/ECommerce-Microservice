# Discovery Server

This module provides a Eureka Discovery Server for the microservices architecture. It enables service registration and discovery, allowing microservices to find and communicate with each other dynamically.

---

## Tech Stack
- Java 17
- Spring Boot
- Spring Cloud Netflix Eureka Server
- Maven

---

## Features
- Centralized service registry for all microservices
- Enables dynamic discovery of services
- Supports high availability and load balancing (when clustered)

---

## Setup
1. Clone the repository.
2. Navigate to the `discovery-server` directory.
3. Build the project:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```
5. By default, the Eureka dashboard will be available at `http://localhost:8761`.

---

## Usage
- Other microservices (such as payment-service, order-service, product-service) should be configured as Eureka clients to register themselves with this server.
- The dashboard provides a UI to monitor registered services and their status.

---

## Notes
- No business APIs are exposed by this service; it is purely infrastructural.
- For production, consider running multiple instances for high availability.

---

## License
This project is for demonstration and educational purposes.

