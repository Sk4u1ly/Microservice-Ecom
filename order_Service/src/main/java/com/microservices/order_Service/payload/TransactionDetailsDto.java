package com.microservices.order_Service.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDetailsDto {

    private long orderId;
    private long amount;
    private String referenceNumber;
    private PaymentMode paymentMode;
}