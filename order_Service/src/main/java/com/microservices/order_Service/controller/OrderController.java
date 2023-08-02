package com.microservices.order_Service.controller;

import com.microservices.order_Service.entity.Order;
import com.microservices.order_Service.payload.OrderDto;
import com.microservices.order_Service.payload.OrderResponseDto;
import com.microservices.order_Service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping()
    public ResponseEntity<Order> createOrder(@RequestBody OrderDto orderDto) {
        Order savedOrder = orderService.saveOrder(orderDto);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    @GetMapping("order/{orderId}")
    public ResponseEntity<OrderResponseDto>getOrderId(@PathVariable long orderId){
        OrderResponseDto dtos =orderService.getOrderId(orderId);
        return new ResponseEntity<>(dtos,HttpStatus.OK);
    }
}
