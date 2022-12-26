package shopping.cart.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import shopping.cart.demo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public Product findByProductName(String productName);
	
	public List<Product> findAll();
	
	public void deleteById(Long productCode);
	
	@Query(value = "SELECT p FROM Product p ORDER BY product_name")
	public List<Product> findAllSortedByName();
	
	@Query(value = "SELECT * FROM PRODUCTS ORDER BY product_name", nativeQuery = true)
	public List<Product> findAllSortedByNameUsingNative();

} 