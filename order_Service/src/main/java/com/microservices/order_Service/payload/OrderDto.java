package com.microservices.order_Service.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private  long Id;
    private long productId;
    private long quantity;
    private long amount;
    private PaymentMode paymentMode;
    private String orderStatus;

}
