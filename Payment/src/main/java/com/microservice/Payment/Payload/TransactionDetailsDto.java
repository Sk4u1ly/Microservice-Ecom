package com.microservice.Payment.Payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDetailsDto {
    private long paymentId;
    private String Status;
    private long orderId;
    private Instant PaymentDate;
    private long amount;
    private String referenceNumber;
    private PaymentMode paymentMode;
}