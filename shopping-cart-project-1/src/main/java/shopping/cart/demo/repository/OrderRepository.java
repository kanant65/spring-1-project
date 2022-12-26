package shopping.cart.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import shopping.cart.demo.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	public Order findByComments(String comments);
	
	public List<Order> findAll();
	
	public void deleteById(Long orderNumber);
	
	@Query(value = "SELECT o FROM Order o WHERE status = true")
	public List<Order> findAllByStatusTrue();
	
	@Query(value = "SELECT * FROM ORDERS ORDER BY comments", nativeQuery = true)
	public List<Order> findAllSortedByCommentUsingNative();
}

