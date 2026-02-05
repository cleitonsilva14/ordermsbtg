package br.com.btgbackend.orderms.controller;

import br.com.btgbackend.orderms.dto.ApiResponse;
import br.com.btgbackend.orderms.dto.OrderResponse;
import br.com.btgbackend.orderms.repository.OrderRepository;
import br.com.btgbackend.orderms.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @GetMapping("/customer/{customerId}/order")
    public ResponseEntity<ApiResponse<OrderResponse>> getOrders(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size){

        return ResponseEntity.ok().body(null);

    }





}
