package com.spring.RelationalMapping.repository;

import com.spring.RelationalMapping.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepo extends CrudRepository<Order,Integer> {

    Order findByorderId(@Param("orderId") Integer orderId);

    List<Order> findByTitle(String title);
}
