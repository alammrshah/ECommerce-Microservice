package com.microservice.apiGatway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {


    // Fallback endpoint for Product Service
    // This endpoint will be called when the Product Service is unavailable
    // It returns a simple message indicating that the service is down
    @GetMapping("/fallback/product")
    public ResponseEntity<String> productServiceFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Product Service is currently unavailable. Please try again later.");
    }
}
