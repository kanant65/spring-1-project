package com.shoppingcart.app.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.model.Office;
import com.shoppingcart.app.repository.OfficeRepository;
import com.shoppingcart.app.service.OfficeService;

@Service
public class OfficeServiceImpl implements OfficeService {

	@Autowired
	private OfficeRepository officeRepository;
	
	//get all Offices
	@Override
	public List<Office> getAllOffices() {
		List<Office> list = officeRepository.findAll();
		return list;
		
	}

	//get single Office by id
	@Override
	public Optional<Office> getOfficeById(Long id) {
		Optional<Office> office = officeRepository.findById(id);
		return office;
	}

	//adding the Office
	@Override
	public Office addOffice(Office office) {
		Office result = officeRepository.save(office);
		return result;
	}

	//delete the Office
	@Override
	public void deleteOffice(Long officeId) {
		officeRepository.deleteById(officeId);
		
	}

	//update the Office
	@Override
	public void updateOffice(Office office, Long officeId) {
		// TODO Auto-generated method stub
		
	}

	//get all Offices sorted by city using query
	@Override
	public List<Office> getOfficeSortedByCity() {
		List<Office> list = officeRepository.findAllSortedByCity();
		return list;
	}

	//get all Offices sorted by country using native query
	@Override
	public List<Office> getOfficeSortedByCountryUsingNative() {
		List<Office> list = officeRepository.findAllSortedByCountryUsingNative();
		return list;
	}

	//get all Offices by matched country
	@Override
	public List<Office> getOfficeByCountry(String country) {
		List<Office> list = officeRepository.findByCountry(country);
		return list;
	}

	//get Offices using paging
	@Override
	public List<Office> getOfficesUsingPaging() {
		Pageable pageable = PageRequest.of(0, 2);
		List<Office> list = officeRepository.findOffices(pageable);
		return list;
	}

	//get Offices sorted by teritory using Sorting
	@Override
	public Iterable<Office> getSortOfficesUsingSorting() {
		String sortBy = "teritory";
		List<Office> list = (List<Office>) officeRepository.sortOffice(Sort.by(Sort.Direction.ASC,sortBy));
		return list;
	}

}
