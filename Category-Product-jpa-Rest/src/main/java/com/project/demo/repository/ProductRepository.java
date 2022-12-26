package com.project.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query(value = "Select c from Product c Where c.name = 'Burbon'")
	public Product findByName();
	
	@Query(value = "SELECT * FROM products Where name like 'Kur%'", nativeQuery = true)
	public List<Product> findByNames(); 
	
	@Query(value = "Select c from Product c Where c.price between 300 and 1200")
	public Product findByPrice();
	
	@Query(value = "SELECT * FROM products Where discontinued = true", nativeQuery = true)
	public List<Product> findByProductsDiscontinued(); 
	
	@Query(value = "from Product")
	public List<Product> findProducts(Pageable pageable);
	
	@Query("from Product" )
	public Iterable<Product> sortProduct(Sort sort);
}
