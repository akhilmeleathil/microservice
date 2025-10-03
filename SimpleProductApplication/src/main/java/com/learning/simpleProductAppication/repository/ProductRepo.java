package com.learning.simpleProductAppication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learning.simpleProductAppication.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

	@Query("SELECT p FROM Product p WHERE LOWER(p.prodName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	List<Product> findByKeyword(String keyword);

}
