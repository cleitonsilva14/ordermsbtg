package br.com.btgbackend.orderms.dto;

import java.math.BigDecimal;

public record OrderResponse(Long orderId, Long customerId, BigDecimal total) {
}
