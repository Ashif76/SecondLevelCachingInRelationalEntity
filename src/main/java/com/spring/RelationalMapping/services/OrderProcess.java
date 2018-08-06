package com.spring.RelationalMapping.services;

import com.spring.RelationalMapping.model.Order;
import com.spring.RelationalMapping.model.OrderItem;
import com.spring.RelationalMapping.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderProcess implements IOrderProcess<Order> {

    @Autowired
    private OrderRepo orderRepo;

    @Cacheable(value="orderCache",key="#orderId",unless="#result==null")
    public Order doProcessOrder(int orderId){
        Order order = new Order();
        order.setTitle("Cust_product15");
        order.setOrderId(orderId);
        List<OrderItem> lItem = new ArrayList<>();
        for(int i=orderId ; i<orderId+4; i++){
           final OrderItem orderItem = new OrderItem();
           orderItem.setOrderId(orderId);
            orderItem.setTitle("item"+i);
            lItem.add(orderItem);
        }
        order.setItems(lItem);
        orderRepo.save(order);
        return order;
    }

    @Override
    @Cacheable(value="orderCache",key="#orderId",unless="#result==null")
    public Order doGetAllCourseWithOrders(final int orderId) {
        return orderRepo.findByorderId(orderId);
    }

    @Override
    public Order doGetOrder(final int orderId) {
        return null;
    }

    @Override
    @Cacheable(value="orderCache",key="#title",unless="#result==null")
    public List<Order> doGetAllOrdersWithOrders(final String title) {
        return orderRepo.findByTitle(title);
    }
}
