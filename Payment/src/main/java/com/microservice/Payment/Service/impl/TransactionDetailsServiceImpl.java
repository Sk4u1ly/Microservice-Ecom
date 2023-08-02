package com.microservice.Payment.Service.impl;

import com.microservice.Payment.Exception.PaymentDetailsNotFoundException;
import com.microservice.Payment.Payload.PaymentMode;
import com.microservice.Payment.Payload.TransactionDetailsDto;
import com.microservice.Payment.Service.TransactionDetailsService;
import com.microservice.Payment.entity.TransactionDetails;
import com.microservice.Payment.repository.TransactionDetailsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.Instant;


@Service
@Log4j2
public class TransactionDetailsServiceImpl implements TransactionDetailsService {


    private final TransactionDetailsRepository transactionDetailsRepository;

    public TransactionDetailsServiceImpl(TransactionDetailsRepository transactionDetailsRepository) {
        this.transactionDetailsRepository = transactionDetailsRepository;
    }

    @Override
    public void doPayment(TransactionDetailsDto dto) {
        TransactionDetails td = TransactionDetails.builder()
                .paymentDate(Instant.now())
                .PaymentMode(dto.getPaymentMode().name())
                .paymentStatus("SUCCESS")
                .orderId(dto.getOrderId())
                .referenceNumber(dto.getReferenceNumber())
                .amount(dto.getAmount())
                .build();
        log.info("The payment is done");
        transactionDetailsRepository.save(td);

    }

    @Override
    public TransactionDetailsDto getPaymentDetails(long orderId) {

        TransactionDetails trs= transactionDetailsRepository.findByOrderId(orderId);
        if(trs==null){
            throw new PaymentDetailsNotFoundException("Payment details not found for orderId: " + orderId);
        }
         TransactionDetailsDto Dto =TransactionDetailsDto.builder()
                 .paymentId(trs.getId())
                 .paymentMode(PaymentMode.valueOf(trs.getPaymentMode()))
                 .PaymentDate(trs.getPaymentDate())
                 .Status(trs.getPaymentStatus())
                 .orderId(trs.getOrderId())
                 .amount(trs.getAmount())
                 .build();

        return Dto;
    }

}

