package com.learnbasicjava.dao;

import com.learnbasicjava.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order, Long> {

}
