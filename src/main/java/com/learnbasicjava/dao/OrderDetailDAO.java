package com.learnbasicjava.dao;

import com.learnbasicjava.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer> {

}
