package com.example.payment_service.exception;

import java.time.LocalDateTime;

public class PaymentFunctionalException extends Exception{

    private final String errorCode;
    private final String errorMessage;
    private final LocalDateTime timestamp;

    public PaymentFunctionalException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.timestamp = LocalDateTime.now();
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
