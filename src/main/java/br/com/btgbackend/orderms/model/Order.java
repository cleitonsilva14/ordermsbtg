package br.com.btgbackend.orderms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "tb_order")
public class Order {

    @MongoId
    private Long orderId;
    private Long customerId;
    private BigDecimal total;
    private List<OrderItem> items;

}
