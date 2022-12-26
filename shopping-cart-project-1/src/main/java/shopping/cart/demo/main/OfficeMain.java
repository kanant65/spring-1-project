package shopping.cart.demo.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import shopping.cart.demo.controller.OfficeController;
import shopping.cart.demo.exception.OfficeNotFoundException;
import shopping.cart.demo.model.Office;

@Controller
public class OfficeMain {
	
	@Autowired
	private OfficeController officeController;

	public void officeRun() {
		System.out.println("\n Office Entity records :");
		addOffices(createOffices());
	}

	//method to add Office
	private void addOffices(List<Office> offices) {
		for(Office office : offices) {
			try {
				officeController.addOffice(office);
			} 
			catch (OfficeNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//method to create List of Offi
	private List<Office> createOffices(){
		List<Office> offices = new ArrayList<Office>();
		
		Office of1 = new Office("Ranchi", "9992344910", "Kanke Road Ranchi", "Hinoo Doranda Ranchi",
				"Jharkhand", "India", "834012", "Pvt Area", null);
		
		Office of2 = new Office("Bangalore", "7777777910", "Main Road Bangalore", "Kormangala Bangalore",
				"Karnatka", "India", "659012", "Govt Area", null);
		
		Office of3 = new Office("Delhi", "6754244910", "Chandani Chowk", "New Delhi",
				"Delhi", "India", "765352", "Local Area", null);
	
		offices.add(of1);
		offices.add(of2);
		offices.add(of3);
		
		return offices;
	}

}
