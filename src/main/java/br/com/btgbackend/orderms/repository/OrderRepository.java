package br.com.btgbackend.orderms.repository;


import br.com.btgbackend.orderms.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long> {
}
