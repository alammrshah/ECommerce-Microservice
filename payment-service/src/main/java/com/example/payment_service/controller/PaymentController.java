package com.example.payment_service.controller;

import com.example.payment_service.dto.PaymentRequestDto;
import com.example.payment_service.dto.PaymentResponseDto;
import com.example.payment_service.exception.PaymentException;
import com.example.payment_service.exception.PaymentFunctionalException;
import com.example.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponseDto> processPayment(@RequestBody PaymentRequestDto paymentRequestDto) throws PaymentException, PaymentFunctionalException {
        return  ResponseEntity.ok(paymentService.processPayment(paymentRequestDto));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<PaymentResponseDto> getPaymentByOrderId(@PathVariable String orderId) throws PaymentException {
        return ResponseEntity.ok(paymentService.getPaymentByOrderId(orderId));
    }


}
