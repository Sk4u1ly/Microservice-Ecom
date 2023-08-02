package com.microservice.Payment.repository;

import com.microservice.Payment.Payload.TransactionDetailsDto;
import com.microservice.Payment.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails,Long> {

    TransactionDetails findByOrderId(long orderId);
}
