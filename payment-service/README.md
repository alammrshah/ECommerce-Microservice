# Payment Service

A Spring Boot microservice for handling payments in an e-commerce application. This service processes payments, retrieves payment details by order, and integrates with other microservices via Eureka service discovery.

---

## Tech Stack
- Java 17
- Spring Boot (REST API, Data JPA)
- Spring Cloud (Eureka Client)
- H2 Database (in-memory, for development/testing)
- Maven
- Lombok
- JUnit (testing)

---

## Features
- Process payments for orders
- Retrieve payment details by order ID
- Exception handling for payment errors
- Service registration with Eureka for microservices architecture

---

## Setup
1. Clone the repository.
2. Navigate to the `payment-service` directory.
3. Build the project:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```
5. The service will register with Eureka if the discovery server is running.

---

## API Endpoints

### 1. Process Payment
- **POST /payments**
- **Purpose:** Process a payment for an order.
- **Request Body:**
  ```json
  {
    "orderId": "string",
    "amount": number,
    "paymentMethod": "string"
  }
  ```
- **Response:**
  ```json
  {
    "paymentId": "string",
    "orderId": "string",
    "status": "SUCCESS" | "FAILED",
    "timestamp": "ISO8601 string"
  }
  ```

### 2. Get Payment by Order ID
- **GET /payments/order/{orderId}**
- **Purpose:** Retrieve payment details for a specific order.
- **Path Variable:** `orderId` (string)
- **Response:**
  ```json
  {
    "paymentId": "string",
    "orderId": "string",
    "status": "SUCCESS" | "FAILED",
    "timestamp": "ISO8601 string"
  }
  ```

---

## Notes
- The service uses an in-memory H2 database by default. For production, configure a persistent database in `application.properties`.
- Ensure Eureka Discovery Server is running for service registration.
- Exception handling is implemented for robust error responses.

---

## License
This project is for demonstration and educational purposes.

