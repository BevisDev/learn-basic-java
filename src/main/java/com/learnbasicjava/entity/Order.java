package com.learnbasicjava.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "orderdate")
    @Temporal(TemporalType.TIMESTAMP)
    Date orderDate;
    String address;
    Double amount;

    @ManyToOne
    @JoinColumn(name = "username")
    Account account;

    @OneToMany(mappedBy = "order")
    List<OrderDetail> orderDetails;
}
