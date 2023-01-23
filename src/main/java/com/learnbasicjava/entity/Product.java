package com.learnbasicjava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    public Product(Integer id, String name, Double unitPrice) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
    }

}