package com.microservices.order_Service.service;

import com.microservices.order_Service.entity.Order;
import com.microservices.order_Service.payload.OrderDto;
import com.microservices.order_Service.payload.OrderResponseDto;


public interface OrderService {
    Order saveOrder(OrderDto orderDto);

    OrderResponseDto getOrderId(long orderId);


}
