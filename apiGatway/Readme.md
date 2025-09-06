# API Gateway Service

This service acts as the API Gateway for your microservices architecture, providing a single entry point for all client requests and routing them to the appropriate backend services.

---

## Tech Stack
- Java 17
- Spring Boot (WebFlux)
- Spring Cloud Gateway
- Spring Cloud Netflix Eureka Client
- Redis (Reactive)
- Resilience4j (Circuit Breaker)
- Maven

---

## Features
- **API Gateway Pattern:** Central entry point for all microservices.
- **Dynamic Routing:** Forwards requests to backend services based on route configuration.
- **Service Discovery:** Integrates with Eureka to discover and route to registered services.
- **Circuit Breaker:** Uses Resilience4j to provide fault tolerance and fallback mechanisms.
- **Fallback Endpoints:** Returns user-friendly messages when backend services are unavailable (e.g., `/fallback/product`).
- **Reactive Programming:** Built with WebFlux for high concurrency and scalability.
- **Redis Integration:** Supports caching or rate limiting using reactive Redis.

---

## Setup
1. Clone the repository.
2. Navigate to the `apiGatway` directory.
3. Build the project:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```
5. Configure routes and gateway rules in `src/main/resources/application.yml` or `application.properties` as needed.

---

## Example Fallback Endpoint
- **GET /fallback/product**
  - Returns a message if the Product Service is unavailable.
  - Response: `Product Service is currently unavailable. Please try again later.`

---

## Usage
- The API Gateway will automatically discover and route to services registered with Eureka.
- Add or modify routes in the configuration files to control how requests are forwarded.
- Use fallback endpoints to provide graceful error handling for users.

---

## License
This project is for demonstration and educational purposes.

