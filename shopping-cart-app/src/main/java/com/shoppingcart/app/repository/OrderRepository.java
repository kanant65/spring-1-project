package com.shoppingcart.app.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoppingcart.app.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	@Query(value = "SELECT o FROM Order o WHERE status = true")
	public List<Order> findAllByStatusTrue();
	
	@Query(value = "SELECT * FROM ORDERS ORDER BY comments", nativeQuery = true)
	public List<Order> findAllSortedByCommentUsingNative();
	
	@Query(value = "FROM Order")
	public List<Order> findOrders(Pageable pageable);
	
	@Query("from Order" )
	public Iterable<Order> sortOrder(Sort sort);
}

