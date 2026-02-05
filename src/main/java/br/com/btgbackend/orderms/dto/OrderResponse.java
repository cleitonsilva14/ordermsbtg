package br.com.btgbackend.orderms.dto;

import br.com.btgbackend.orderms.model.Order;

import java.math.BigDecimal;

public record OrderResponse(Long orderId, Long customerId, BigDecimal total) {

    public static OrderResponse from(Order order){
        return new OrderResponse(order.getOrderId(), order.getCustomerId(), order.getTotal());
    }

}
