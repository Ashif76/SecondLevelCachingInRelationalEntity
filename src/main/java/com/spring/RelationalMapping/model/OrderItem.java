package com.spring.RelationalMapping.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "orderitem")
@Setter
@Getter
@Cacheable
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String title;
    @Column(name = "order_id")
    int orderId;


}
