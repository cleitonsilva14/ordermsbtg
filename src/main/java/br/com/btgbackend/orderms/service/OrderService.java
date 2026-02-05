package br.com.btgbackend.orderms.service;

import br.com.btgbackend.orderms.dto.OrderCreatedEvent;
import br.com.btgbackend.orderms.dto.OrderResponse;
import br.com.btgbackend.orderms.model.Order;
import br.com.btgbackend.orderms.model.OrderItem;
import br.com.btgbackend.orderms.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void save(OrderCreatedEvent event) {
        var entity = new Order();

        entity.setOrderId(event.codigoPedido());
        entity.setCustomerId(event.codigoCliente());

        entity.setTotal(getTotal(event));

        entity.setItems(getItems(event));

        orderRepository.save(entity);

    }

    public Page<OrderResponse> getAllByCustomerId(Long customerId, PageRequest pageRequest){

        var orders = orderRepository
                .findByCustomerId(customerId, pageRequest);

        return orders.map(OrderResponse::from);

    }

    public static BigDecimal getTotal(OrderCreatedEvent event){
        return event.itens()
                .stream()
                .map(item -> item.preco().multiply(BigDecimal.valueOf(item.quantidade())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public static List<OrderItem> getItems (OrderCreatedEvent event) {
        return event.itens()
                .stream()
                .map(item -> new OrderItem(item.produto(), item.quantidade(), item.preco()))
                .toList();
    }

}
