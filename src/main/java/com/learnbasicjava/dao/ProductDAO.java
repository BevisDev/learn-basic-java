package com.learnbasicjava.dao;


import com.learnbasicjava.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductDAO extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.unitPrice BETWEEN ?1 AND ?2")
    Page<Product> findByPrice(double min, double max, Pageable pageable);

//	@Query("SELECT  p.category.nameVn, sum(p.quantity) FROM Product p GROUP BY p.category.nameVn")
//	List<Object[]> getInventory();

    Page<Product> findAllByUnitPriceBetween(double min, double max, Pageable pageable);


}
