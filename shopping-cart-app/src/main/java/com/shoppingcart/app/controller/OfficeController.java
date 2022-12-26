package com.shoppingcart.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.app.exception.OfficeNotFoundException;
import com.shoppingcart.app.model.Office;
import com.shoppingcart.app.service.OfficeService;

@RestController
@RequestMapping("/api/v1/")
public class OfficeController {

	@Autowired
	private OfficeService officeService;

	//get all Offices handler
	@GetMapping("offices")
	public ResponseEntity<List<Office>> getAllOffices() throws OfficeNotFoundException {
		List<Office> office = officeService.getAllOffices();
		
		if(office.size()<=0) {
			throw new OfficeNotFoundException("Office record is empty");
		}
		return ResponseEntity.of(Optional.of(office));
	}

	//get single Office handler by id
	@GetMapping("offices/{id}")
	public ResponseEntity<Office> getoffice(@PathVariable("id") Long id) throws OfficeNotFoundException  {
		Office office = officeService.getOfficeById(id)
				 .orElseThrow(() -> new OfficeNotFoundException("Office not exist with id:" + id));
		
		if(office == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(office));
	}
	
	//new Office handler
	@PostMapping("offices")
	public ResponseEntity<Office> addOffice(@RequestBody Office office) throws OfficeNotFoundException {
		Office o = officeService.addOffice(office);
		
		if(o == null) {
			throw new OfficeNotFoundException("Office not get inserted");
		}
		return ResponseEntity.of(Optional.of(o));
		
	}
	
	//delete Office handler
	@DeleteMapping("offices/{officeId}")
	public ResponseEntity<Void> deleteOffice(@PathVariable("officeId") Long officeId) throws OfficeNotFoundException {
		
		officeService.getOfficeById(officeId)
			 .orElseThrow(() -> new OfficeNotFoundException("Office not exist with id:" + officeId));
		
		officeService.deleteOffice(officeId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	//update Office handler
	@PutMapping("offices/{officeId}")
	public ResponseEntity<Office> updateOffice(@RequestBody Office office, @PathVariable("officeId") Long officeId) throws OfficeNotFoundException {
		
		officeService.getOfficeById(officeId)
		 .orElseThrow(() -> new OfficeNotFoundException("Office not exist with id:" + officeId));
		
		officeService.updateOffice(office, officeId);
		return ResponseEntity.ok(office);
		
	}
	
	//get all Offices handler sorted by city using query
	@GetMapping("offices/sort")
	public ResponseEntity<List<Office>> getOfficeSortedByCity() throws OfficeNotFoundException {
		List<Office> office = officeService.getOfficeSortedByCity();
		
		if(office.size()<=0) {
			throw new OfficeNotFoundException("Office not exists ");
		}
		return ResponseEntity.of(Optional.of(office));
	}
	
	//get all Offices handler sorted by country using native query
	@GetMapping("offices/sort/native")
	public ResponseEntity<List<Office>> getOfficeSortedByCountryUsingNative() throws OfficeNotFoundException {
		List<Office> office = officeService.getOfficeSortedByCountryUsingNative();
		
		if(office.size()<=0) {
			throw new OfficeNotFoundException("Office not exists ");
		}
		return ResponseEntity.of(Optional.of(office));
	}
	
	//get Offices handler by country
	@GetMapping("offices/country/{country}")
	public ResponseEntity<List<Office>> getOfficeByCountry(@PathVariable("country") String country) throws OfficeNotFoundException{
		List<Office> office = officeService.getOfficeByCountry(country);
		
		if(office == null) {
			throw new OfficeNotFoundException("Office not exists with country : " + country);
		}
		return ResponseEntity.of(Optional.of(office));
	}

	//implementing paging
	@GetMapping("offices/paging")
	public ResponseEntity<List<Office>> getOffices() throws OfficeNotFoundException{
		List<Office> office  = officeService.getOfficesUsingPaging();
		
		if(office.size()<=0) {
			throw new OfficeNotFoundException("Product not exist");
		}
		return ResponseEntity.of(Optional.of(office));
	}

	//sorting implementation
	@GetMapping("offices/sorting")
	public ResponseEntity<Iterable<Office>> getSortOffices() throws OfficeNotFoundException {
		List<Office> office = (List<Office>) officeService.getSortOfficesUsingSorting();
		
		if(office.size()<=0) {
			throw new OfficeNotFoundException("Office not exist");
		}
		return ResponseEntity.of(Optional.of(office));
	}
	
}
