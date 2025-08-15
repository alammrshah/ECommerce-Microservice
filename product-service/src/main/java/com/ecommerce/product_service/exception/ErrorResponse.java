package com.ecommerce.product_service.exception;

import java.time.LocalDateTime;

public class ErrorResponse {

    private String errorCode;
    private String errorMessage;
    private LocalDateTime timestamp;

    public ErrorResponse(String errorCode, String errorMessage, LocalDateTime timestamp) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.timestamp = timestamp;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
