package com.shoppingcart.app.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoppingcart.app.model.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {

	public List<Office> findByCountry(String country);
	
	@Query(value = "SELECT o FROM Office o WHERE country = ?1 AND state = ?2")
	public List<Office> findByCountryAndState(String country, String state);

	@Query(value = "SELECT o FROM Office o ORDER BY city")
	public List<Office> findAllSortedByCity();
	
	@Query(value = "SELECT * FROM OFFICES ORDER BY country", nativeQuery = true)
	public List<Office> findAllSortedByCountryUsingNative();
	
	@Query("SELECT o FROM Office o")
	public List<Office> findOffices(Pageable pageable);
	
	@Query("from Office" )
	public Iterable<Office> sortOffice(Sort sort);
}


