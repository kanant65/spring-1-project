package shopping.cart.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import shopping.cart.demo.model.ProductLine;

@Repository
public interface ProductLineRepository extends JpaRepository<ProductLine, Long>{

	public List<ProductLine> findAll();
	
	public void deleteById(Long productLine);
	
	@Query(value = "SELECT p FROM ProductLine p ORDER BY text_description")
	public List<ProductLine> findAllSortedByText();
	
	@Query(value = "SELECT * FROM PRODUCTLINES ORDER BY text_description", nativeQuery = true)
	public List<ProductLine> findAllSortedByTextUsingNative();
	
}
