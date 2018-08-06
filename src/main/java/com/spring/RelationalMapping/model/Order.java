package com.spring.RelationalMapping.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Setter
@Getter
@Entity(name = "orders")
@Cacheable
public class Order {

    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String title;
    @Id
    int orderId;
    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    List<OrderItem> items ;
}
