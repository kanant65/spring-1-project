package com.shoppingcart.app.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoppingcart.app.model.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
	
	public List<OrderDetail> findByQuantityOrdered(int quantityOrdered);
	
	@Query(value = "SELECT o FROM OrderDetail o ORDER BY quantity_ordered")
	public List<OrderDetail> findAllSortedByQuantity();
	
	@Query(value = "SELECT * FROM ORDERDETAILS ORDER BY price_each", nativeQuery = true)
	public List<OrderDetail> findAllSortedByPriceEachUsingNative();
	
	@Query(value = "FROM OrderDetail")
	public List<OrderDetail> findOrderDetails(Pageable pageable);
	
	@Query("from OrderDetail" )
	public Iterable<OrderDetail> sortOrderDetail(Sort sort);
}
