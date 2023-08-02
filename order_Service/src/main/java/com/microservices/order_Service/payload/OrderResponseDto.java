package com.microservices.order_Service.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDto {
    private long orderId;
    private Instant orderDate;
    private String orderStatus;
    private long orderAmount;
    private ProductData productData;
    private TransactionDetailsDto transactionDetailsDto;

}