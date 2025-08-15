# API Gateway - Microservices by Bits and Bytes

## Overview

This project is a Spring Cloud Gateway application that acts as an API Gateway for a microservices architecture. It provides routing, rate limiting, and centralized entry point for all client requests to backend microservices.

## Features

- **Routing:** Forwards client requests to appropriate microservices.
- **Rate Limiting:** Uses Redis to limit the number of requests per client IP.
- **Key Resolver:** Identifies clients by their IP address for rate limiting.
- **Centralized Logging:** Logs incoming requests and errors for monitoring and debugging.
- **Extensible Filters:** Easily add custom filters for authentication, logging, etc.

## Technologies Used

- Java version 17
- Spring Boot
- Spring Cloud Gateway
- Redis (for rate limiting)
- Maven

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- Redis server running locally or accessible remotely

### Setup

1. **Clone the repository:**