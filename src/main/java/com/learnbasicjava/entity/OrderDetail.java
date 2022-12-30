package com.learnbasicjava.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orderdetails")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "unitprice")
    Double unitPrice;

    @ManyToOne
    @JoinColumn(name = "orderid")
    Order order;

    @ManyToOne
    @JoinColumn(name = "productid")
    Product product;
}
