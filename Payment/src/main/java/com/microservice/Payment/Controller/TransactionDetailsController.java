package com.microservice.Payment.Controller;

import com.microservice.Payment.Payload.TransactionDetailsDto;
import com.microservice.Payment.Service.TransactionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class TransactionDetailsController {

   private final TransactionDetailsService transactionDetailsService;

    public TransactionDetailsController(TransactionDetailsService transactionDetailsService) {
        this.transactionDetailsService = transactionDetailsService;
    }

    @PostMapping()
    public ResponseEntity<?> doPayment(@RequestBody TransactionDetailsDto  dto){
        transactionDetailsService.doPayment(dto);
        return new ResponseEntity<>("PaymentDone", HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<TransactionDetailsDto>getPaymentDetails(@PathVariable long orderId){
        TransactionDetailsDto Dto=transactionDetailsService.getPaymentDetails(orderId);
        return new ResponseEntity<>(Dto, HttpStatus.OK);
    }

}
