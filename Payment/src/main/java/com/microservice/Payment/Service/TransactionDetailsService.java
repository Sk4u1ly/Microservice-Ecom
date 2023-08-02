package com.microservice.Payment.Service;

import com.microservice.Payment.Payload.TransactionDetailsDto;

public interface TransactionDetailsService {
    void doPayment(TransactionDetailsDto dto);


    TransactionDetailsDto getPaymentDetails(long orderId);
}
