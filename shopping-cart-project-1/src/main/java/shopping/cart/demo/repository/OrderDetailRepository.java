package shopping.cart.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import shopping.cart.demo.model.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
	
	public List<OrderDetail> findAll();
	
	public void deleteById(Long orderNumber);
	
	@Query(value = "SELECT o FROM OrderDetail o ORDER BY quantity_ordered")
	public List<OrderDetail> findAllSortedByQuantity();
	
	@Query(value = "SELECT * FROM ORDERDETAILS ORDER BY quantity_ordered", nativeQuery = true)
	public List<OrderDetail> findAllSortedByQuantityUsingNative();
}
