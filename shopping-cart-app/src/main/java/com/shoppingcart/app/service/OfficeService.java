package com.shoppingcart.app.service;

import java.util.List;
import java.util.Optional;

import com.shoppingcart.app.model.Office;

public interface OfficeService {
	
	public List<Office> getAllOffices();
	
	public Optional<Office> getOfficeById(Long id);
	
	public Office addOffice(Office office);
	
	public void deleteOffice(Long oid);
	
	public void updateOffice(Office office, Long officeId);
	
	public List<Office> getOfficeSortedByCity();
	
	public List<Office> getOfficeSortedByCountryUsingNative();

	public List<Office> getOfficeByCountry(String country);

	public List<Office> getOfficesUsingPaging();
	
	public Iterable<Office> getSortOfficesUsingSorting();
	
}
