package com.microservices.order_Service.service.impl;


import com.microservices.order_Service.Exception.CustomException;
import com.microservices.order_Service.Repository.OrderRepository;
import com.microservices.order_Service.entity.Order;
import com.microservices.order_Service.external.services.PaymentService;
import com.microservices.order_Service.external.services.ProductService;
import com.microservices.order_Service.payload.OrderDto;
import com.microservices.order_Service.payload.OrderResponseDto;
import com.microservices.order_Service.payload.ProductData;
import com.microservices.order_Service.payload.TransactionDetailsDto;
import com.microservices.order_Service.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
@Log4j2
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;
    @Autowired
    private PaymentService paymentService;


    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Order saveOrder(OrderDto orderDto) {
        log.info("call the product service uri");
  productService.reduceQuantity(orderDto.getProductId(),orderDto.getQuantity());

    log.info("Creating order with status CREATED");
        Order order = Order.builder()
                .productId(orderDto.getProductId())
                .quantity(orderDto.getQuantity())
                .amount(orderDto.getAmount())
                .orderStatus(orderDto.getOrderStatus())
                .paymentMode(orderDto.getPaymentMode())
                .build();

        order=orderRepository.save(order);
        log.info("Calling Payment Services");
        TransactionDetailsDto dto = TransactionDetailsDto.builder()
                .orderId(order.getId())
                .paymentMode(orderDto.getPaymentMode())
                .amount(orderDto.getAmount())

                .build();


      String OrderStatus =null;
        try {
           paymentService.doPayment(dto);
            log.info("payment done Successfully");
            OrderStatus ="PLACED";

        }
        catch(Exception ignored){

            OrderStatus ="NOT_PLACED";

        }


   log.info("Order place Successfully with orderId ");
        return order;
    }

    @Override
    public  OrderResponseDto getOrderId(long orderId) {

        Order  order = orderRepository.findById(orderId)
                .orElseThrow(()-> new CustomException("Not available for this orderId:"+orderId ,"NOT_FOUND",404));
        ProductData productData = restTemplate.getForObject("http://PRODUCT-APPLICATION/product/"+order.getProductId(),ProductData.class);
        TransactionDetailsDto transactionDetailsDto =restTemplate.getForObject("http://PAYMENT-APPLICATION/payment/"+order.getId(),TransactionDetailsDto.class);
            OrderResponseDto dtos = OrderResponseDto.builder()
                    .orderId(order.getId())
                    .orderDate(order.getOrderDate())
                    .orderAmount(order.getAmount())
                    .orderStatus(order.getOrderStatus())
                    .productData(productData)
                    .transactionDetailsDto(transactionDetailsDto)
                    .build();

            return dtos;

    }
}


