package com.example.payment_service.service;

import com.example.payment_service.dto.PaymentRequestDto;
import com.example.payment_service.dto.PaymentResponseDto;
import com.example.payment_service.dto.PaymentStatus;
import com.example.payment_service.entity.Payment;
import com.example.payment_service.exception.PaymentException;
import com.example.payment_service.exception.PaymentFunctionalException;
import com.example.payment_service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderClient orderClient;

    public PaymentResponseDto processPayment(PaymentRequestDto paymentRequest) throws PaymentException, PaymentFunctionalException {
        // Generate a unique payment ID

        try {
            String paymentId = generatePaymentId();
            Payment payment = new Payment();
            payment.setPaymentId(paymentId);
            payment.setOrderId(paymentRequest.getOrderId());
            payment.setAmount(paymentRequest.getAmount());
            payment.setPaymentDate(LocalDateTime.now());
            boolean paymentSuccess = new Random().nextBoolean();
            if (paymentSuccess) {
                payment.setPaymentStatus(PaymentStatus.SUCCESS);
                payment.setTransactionId(UUID.randomUUID().toString());
                payment.setCustomerId(paymentRequest.getCustomerId());
                orderClient.updateOrderStatus(paymentRequest.getOrderId(), "CONFIRMED");
            } else {
                payment.setPaymentStatus(PaymentStatus.FAILED);
                payment.setTransactionId("N/A");
                orderClient.updateOrderStatus(paymentRequest.getOrderId(), "CANCELLED");
            }
            paymentRepository.save(payment);
            PaymentResponseDto response = new PaymentResponseDto();
            response.setPaymentId(payment.getPaymentId());
            response.setOrderId(payment.getOrderId());
            response.setCustomerId(payment.getCustomerId());
            response.setAmount(payment.getAmount());
            response.setPaymentStatus(payment.getPaymentStatus());
            response.setPaymentDate(payment.getPaymentDate());
            response.setTransactionId(payment.getTransactionId());
            return response;
        }
        catch (Exception e) {
            throw new PaymentException("500", "Payment processing failed: " + e.getMessage());
        }
    }

    private String generatePaymentId() {
        // Logic to generate a unique payment ID
        return "pay" + UUID.randomUUID().toString().substring(0, 8);
    }

    public PaymentResponseDto getPaymentByOrderId(String orderId) throws PaymentException {
        Payment payment = paymentRepository.findByOrderId(orderId);
        if (payment == null) {
            throw new PaymentException("404","Payment not found for order ID: " + orderId);
        }
        PaymentResponseDto response = new PaymentResponseDto();
        response.setPaymentId(payment.getPaymentId());
        response.setOrderId(payment.getOrderId());
        response.setAmount(payment.getAmount());
        response.setPaymentStatus(payment.getPaymentStatus());
        response.setTransactionId(payment.getTransactionId());
        return response;
    }
}
