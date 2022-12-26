package shopping.cart.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import shopping.cart.demo.model.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {
	
	public Office findByCity(String city);
	
	public List<Office> findAll();
	
	public void deleteById(Long officeCode);
	
	@Query(value = "SELECT o FROM Office o ORDER BY city")
	public List<Office> findAllSortedByCity();
	
	@Query(value = "SELECT * FROM OFFICES ORDER BY city", nativeQuery = true)
	public List<Office> findAllSortedByCityUsingNative();
}


