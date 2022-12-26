package com.shoppingcart.app.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoppingcart.app.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	public List<Employee> findByofficeCode(String officeCode);
	
	@Query(value = "SELECT e FROM Employee e ORDER BY firstName")
	public List<Employee> findAllSortedByFirstName();
	
	@Query(value = "SELECT * FROM EMPLOYEES ORDER BY last_name", nativeQuery = true)
	public List<Employee> findAllSortedByLastNameUsingNative();
	
	@Query(value = "SELECT e FROM Employee e")
	public List<Employee> findEmployees(Pageable pageable);
	
	@Query("from Employee" )
	public Iterable<Employee> sortEmployee(Sort sort);
}

