package com.example.payment_service.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(PaymentException.class)
    public ResponseEntity<ErrorResponse> handlePaymentException(PaymentException ex) {
        log.error("PaymentException occurred: {} - {}", ex.getErrorCode(), ex.getErrorMessage(), ex);
        ErrorResponse error = new ErrorResponse(
                ex.getErrorCode(),
                ex.getErrorMessage(),
                ex.getTimestamp()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PaymentFunctionalException.class)
    public ResponseEntity<ErrorResponse> handlePaymentFunctionalException(PaymentFunctionalException ex) {
        log.warn("PaymentFunctionalException occurred: {} - {}", ex.getErrorCode(), ex.getErrorMessage(), ex);
        ErrorResponse error = new ErrorResponse(
                ex.getErrorCode(),
                ex.getErrorMessage(),
                ex.getTimestamp()
        );
        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    // Catch-all for any other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        log.error("Unhandled exception occurred", ex);
        ErrorResponse error = new ErrorResponse(
                "GEN-500",
                ex.getMessage(),
                java.time.LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
