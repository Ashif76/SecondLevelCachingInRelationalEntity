package com.spring.RelationalMapping.controller;

import com.spring.RelationalMapping.model.Order;
import com.spring.RelationalMapping.model.RequestParameter;
import com.spring.RelationalMapping.services.IOrderProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/university")
public class UniversityDetail {

    @Autowired
    IOrderProcess orderProcess;

    @RequestMapping(method = RequestMethod.POST,path = "orderCreate")
    public Order getCourse(@RequestBody RequestParameter requestParameter){

        return (Order) orderProcess.doProcessOrder(requestParameter.orderId);
    }

    @RequestMapping(method = RequestMethod.GET,path = "order/{orderId}")
    public Order getAllCourse(@PathVariable("orderId") int orderId){
        return orderProcess.doGetAllCourseWithOrders(orderId);
    }

    @RequestMapping(method = RequestMethod.GET,path = "orders/title/{title}")
    public List<Order> getAllOrders(@PathVariable("title") String title){
        return orderProcess.doGetAllOrdersWithOrders(title);
    }
}
