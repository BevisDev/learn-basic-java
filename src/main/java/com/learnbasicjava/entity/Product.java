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
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    @Column(name = "unitprice")
    Double unitPrice;
    @Column(name = "productdate")
    @Temporal(TemporalType.DATE)
    Date productDate;
    Boolean available;
    @ManyToOne
    @JoinColumn(name = "categoryid")
    Category category;

    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetails;
}