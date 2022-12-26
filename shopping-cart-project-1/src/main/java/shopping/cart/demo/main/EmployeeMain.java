package shopping.cart.demo.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import shopping.cart.demo.controller.EmployeeController;
import shopping.cart.demo.exception.EmployeeNotFoundException;
import shopping.cart.demo.model.Employee;

@Controller
public class EmployeeMain {

	@Autowired
	private EmployeeController employeeController;
	
	public void employeeRun() {
		System.out.println("\n Employee Entity records :");
		addEmployees(createEmployees());
	}

	//method to add Employees
	private void addEmployees(List<Employee> employees) {
		for(Employee employee : employees) {
			try {
				employeeController.addEmployee(employee);
			}
			catch (EmployeeNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//method to create List of Employees
	private List<Employee> createEmployees(){
		List<Employee> employees = new ArrayList<Employee>();
		
		Employee e1 = new Employee("Singh", "Nikita", "Part Time", "nik123@gmail.com", 
				"COMTECH21", "Madho Pasupuleti", "Cloud server", null, null, null);
		
		Employee e2 = new Employee("Kandulna", "Ronak", "Full Time", "ron3kan@outlook.com", 
				"NONTECH14", "Nikita Singh", "Java Developer", null, null, null);
		
		Employee e3 = new Employee("Jonas", "Priyanka", "Work From Home", "Priyanka06@gmail.com", 
				"CAPGNTECH", "Ronak Kandulna", "System Worker", null, null, null);
		
		Employee e4 = new Employee("Das", "Alok", "Full Time", "Das01Alok@yahoo.com", 
				"INFOTECH", "Priyanka Jonas", "Manager", null, null, null);
		
		Employee e5 = new Employee("Patel", "Mayuri", "Part Time", "may1234@outlook.com", 
				"TCSION", "Alok Das", "President", null, null, null);
	
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		employees.add(e5);
		
		return employees;
	}
}
