package com.learnbasicjava.dao;


import com.learnbasicjava.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product, Integer> {

}
