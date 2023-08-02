package com.microservices.CloudGateway.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {


     @GetMapping("/orderApplicationFallBack")
    public String orderApplicationFallBack(){

        return "OrderService IS Down ";
    }

    @GetMapping("/paymentApplicationFallBack")
    public String paymentApplicationFallBack(){

        return "PaymentService IS Down ";
    }

    @GetMapping("/productApplicationFallBack")
    public String productApplicationFallBack(){

        return "productService IS Down ";
    }
}
