package com.microservices.order_Service.external.services;


import com.microservices.order_Service.Exception.CustomException;
import com.microservices.order_Service.payload.TransactionDetailsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PAYMENT-APPLICATION/payment")
public interface PaymentService {
    @PostMapping()
    ResponseEntity<?> doPayment(@RequestBody TransactionDetailsDto dto);

    }


