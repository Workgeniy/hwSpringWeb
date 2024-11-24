package org.example.hwspringweb;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

    Order findByNumber(Long number);
}
