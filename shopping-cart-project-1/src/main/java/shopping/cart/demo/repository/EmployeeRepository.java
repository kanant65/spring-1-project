package shopping.cart.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import shopping.cart.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	public List<Employee> findAll();
	
	public Employee findByofficeCode(String officeCode);
	
	public void deleteById(Long employeeNumber);
	
	public List<Employee> findByFirstName(String firstName);
	
	public Employee findByEmail(String email);
	
	@Query(value = "SELECT e FROM Employee e ORDER BY first_name")
	public List<Employee> findAllSortedByName();
	
	@Query(value = "SELECT * FROM EMPLOYEES ORDER BY first_name", nativeQuery = true)
	public List<Employee> findAllSortedByNameUsingNative();
}

