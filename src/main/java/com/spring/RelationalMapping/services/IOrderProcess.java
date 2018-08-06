package com.spring.RelationalMapping.services;

import com.spring.RelationalMapping.model.Order;

import java.util.List;

public interface IOrderProcess<T> {

    public T doProcessOrder(int orderId);

    public Order doGetAllCourseWithOrders(int orderId);

    public T doGetOrder(int orderId);

    List<Order> doGetAllOrdersWithOrders(String title);
}
