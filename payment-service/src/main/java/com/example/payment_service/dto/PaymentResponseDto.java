package com.example.payment_service.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PaymentResponseDto {

    private String paymentId;
    private String orderId;
    private String customerId;
    private Double amount;
    private LocalDateTime paymentDate;
    private String transactionId; // Unique identifier for the transaction
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
}
