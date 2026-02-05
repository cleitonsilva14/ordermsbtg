package br.com.btgbackend.orderms.repository;


import br.com.btgbackend.orderms.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long> {
    Page<Order> findByCustomerId(Long customerId, PageRequest pageRequest);
}
