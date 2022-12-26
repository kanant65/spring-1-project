package shopping.cart.demo.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shopping.cart.demo.exception.OfficeNotFoundException;
import shopping.cart.demo.model.Office;
import shopping.cart.demo.repository.OfficeRepository;

@RestController
@RequestMapping("/api/v1/")
public class OfficeController {

	@Autowired
	private OfficeRepository officeRepository;

	//get all Office handler
	@GetMapping("/offices")
	public ResponseEntity<List<Office>> getOffices() throws OfficeNotFoundException {
		List<Office> list = officeRepository.findAll();
		
		if(list.size()<=0) {
			throw new OfficeNotFoundException("Office not exist");
		}
		return ResponseEntity.of(Optional.of(list));
	}

	//get single Office handler
	@GetMapping("/offices/{id}")
	public ResponseEntity<Office> getoffice(@PathVariable("id") Long id) throws OfficeNotFoundException  {
		Office office = officeRepository.findById(id)
				 .orElseThrow(() -> new OfficeNotFoundException("Office not exist with id:" + id));
		
		if(office == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(office));
	}
	
	//new Office handler
	@PostMapping("/offices")
	public ResponseEntity<Office> addOffice(@RequestBody Office office) throws OfficeNotFoundException {
		Office o = officeRepository.save(office);
		
		if(officeRepository.save(office) == null) {
			throw new OfficeNotFoundException("Office not get inserted");
		}
		return ResponseEntity.of(Optional.of(o));
		
	}
	
	//delete Office handler
	@DeleteMapping("/offices/{officeId}")
	public ResponseEntity<Void> deleteOffice(@PathVariable("officeId") Long officeId) throws OfficeNotFoundException {
		
		Office office = officeRepository.findById(officeId)
				 .orElseThrow(() -> new OfficeNotFoundException("Office not exist with id:" + officeId));
		
		officeRepository.delete(office);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	//update Office handler
	@PutMapping("/offices/{officeId}")
	public ResponseEntity<Office> updateOffice(@RequestBody Office office, @PathVariable("officeId") Long officeId) throws OfficeNotFoundException {
		
		Office updateOffice = officeRepository.findById(officeId)
				 .orElseThrow(() -> new OfficeNotFoundException("Office not exist with id:" + officeId));
		
		updateOffice.setOfficeCode(officeId);
		officeRepository.save(office);
		
		return ResponseEntity.ok(updateOffice);
		
	}
	
	//get all Office handler sorted by name
	@GetMapping("offices/sort")
	public ResponseEntity<List<Office>> getOfficeSortedByCity() throws OfficeNotFoundException {
		List<Office> list = officeRepository.findAllSortedByCity();
		
		if(list.size()<=0) {
			throw new OfficeNotFoundException("Office not exists ");
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	//get all Office handler sorted by name using native
	@GetMapping("offices/sort/native")
	public ResponseEntity<List<Office>> getOfficeSortedByCityUsingNative() throws OfficeNotFoundException {
		List<Office> list = officeRepository.findAllSortedByCityUsingNative();
		
		if(list.size()<=0) {
			throw new OfficeNotFoundException("Office not exists ");
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	//get single Office handler by city
	@GetMapping("offices/city")
	public ResponseEntity<Office> getOfficeByCity(@RequestParam String city) throws OfficeNotFoundException{
		Office office = officeRepository.findByCity(city);
		
		if(office == null) {
			throw new OfficeNotFoundException("Office not exists with city : " + city);
		}
		return ResponseEntity.of(Optional.of(office));
	}
}
