package com.shoppingcart.app.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoppingcart.app.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public List<Product> findByProductName(String productName);
	
	@Query(value = "SELECT p FROM Product p ORDER BY product_name")
	public List<Product> findAllSortedByName();
	
	@Query(value = "SELECT * FROM PRODUCTS ORDER BY msrp", nativeQuery = true)
	public List<Product> findAllSortedByMsrpUsingNative();
	
	@Query("from Product" )
	public List<Product> findProducts(Pageable pageable);
	
	@Query("from Product" )
	public Iterable<Product> sortProduct(Sort sort);

} 