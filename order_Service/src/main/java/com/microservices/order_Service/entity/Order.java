package com.microservices.order_Service.entity;

import com.microservices.order_Service.payload.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "custom_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  long orderId;
    private long productId;
    private long quantity;
    private Instant orderDate;
    private long amount;
    private PaymentMode paymentMode;
    private String orderStatus;


}
