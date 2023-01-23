package com.learnbasicjava.dao;


import com.learnbasicjava.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.unitPrice BETWEEN ?1 AND ?2")
    Page<Product> findByPrice(double min, double max, Pageable pageable);

//	@Query("SELECT  p.category.nameVn, sum(p.quantity) FROM Product p GROUP BY p.category.nameVn")
//	List<Object[]> getInventory();

    // Page to paginate
    Page<Product> findAllByUnitPriceBetween(double min, double max, Pageable pageable);

    // or ORDER BY ... DESC
    // OFFSET ... ROWS FETCH NEXT ... ONLY to get paginate
    // select *
    // from Products
    // order by UnitPrice desc
    // OFFSET 0 rows fetch next 10 rows only

    @Query(value = "SELECT * FROM Products p ORDER BY p.unitPrice DESC OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY ", nativeQuery = true)
    List<Product> findAllProductByUnitPrice();
}
