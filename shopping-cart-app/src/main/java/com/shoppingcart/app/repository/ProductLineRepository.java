package com.shoppingcart.app.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoppingcart.app.model.ProductLine;

@Repository
public interface ProductLineRepository extends JpaRepository<ProductLine, Long>{

	public ProductLine findByImage(String image);
	
	@Query(value = "SELECT p FROM ProductLine p ORDER BY text_description")
	public List<ProductLine> findAllSortedByText();
	
	@Query(value = "SELECT * FROM PRODUCTLINES ORDER BY html_description", nativeQuery = true)
	public List<ProductLine> findAllSortedByHtmlTextUsingNative();
	
	@Query("FROM ProductLine")
	public List<ProductLine> findProductlines(Pageable pageable);
	
	@Query("from ProductLine" )
	public Iterable<ProductLine> sortProductLine(Sort sort);
}
