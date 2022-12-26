package com.shoppingcart.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shoppingcart.app.model.Office;
import com.shoppingcart.app.repository.OfficeRepository;
import com.shoppingcart.app.service.OfficeService;

@SpringBootTest
public class OfficeServiceTest {

	@Autowired
	OfficeService officeService;
	
	@MockBean
	OfficeRepository officeRepository;
	
	@Test
	public void getAllOfficesTest() {
		Office office = new Office();
		
		office.setOfficeCode(1L);
		office.setAddressLine1("Gaya, Bihar");
		office.setCity("Gaya");
		office.setState("Bihar");
		office.setCountry("India");
		office.setPostalCode("432010");
		
		Mockito.when(officeRepository.save(office)).
		thenReturn(office);
		assertThat(officeService.getAllOffices()).
		isNotNull();
	}
	
	@Test
	public void getOfficeByIdTest() {
		Office office = new Office();
		
		office.setOfficeCode(1L);
		office.setAddressLine1("Gaya, Bihar");
		office.setCity("Gaya");
		office.setState("Bihar");
		office.setCountry("India");
		office.setPostalCode("432010");
		
		Mockito.when(officeRepository.save(office)).
		thenReturn(office);
		assertThat(officeService.getOfficeById(1L)).
		isNotNull();
	}
	
	@Test
	public void addOfficeTest() {
		Office office = new Office();
		
		office.setOfficeCode(1L);
		office.setAddressLine1("Gaya, Bihar");
		office.setCity("Gaya");
		office.setState("Bihar");
		office.setCountry("India");
		office.setPostalCode("432010");
		
		Mockito.when(officeRepository.save(office)).
		thenReturn(office);
		assertThat(officeService.addOffice(office)).
		isEqualTo(office);	
	}
	
	@Test
	public void deleteOfficeTest() {
		Office office = new Office();
		
		office.setOfficeCode(1L);
		office.setAddressLine1("Gaya, Bihar");
		office.setCity("Gaya");
		office.setState("Bihar");
		office.setCountry("India");
		office.setPostalCode("432010");
		
		Mockito.when(officeRepository.save(office)).
		thenReturn(office);
		officeService.deleteOffice(1L);
		assertThat(officeService.getOfficeById(1L)).
		isNotNull();
	}
	
	@Test
	public void updateOfficeTest() {
		Office office = new Office();
		
		office.setOfficeCode(1L);
		office.setAddressLine1("Gaya, Bihar");
		office.setCity("Gaya");
		office.setState("Bihar");
		office.setCountry("India");
		office.setPostalCode("432010");
		
		Mockito.when(officeRepository.save(office)).
		thenReturn(office);
		officeService.updateOffice(office, 2L);
		assertThat(officeService.getOfficeById(1L)).
		isEmpty();
	}
	
	@Test
	public void getOfficeSortedByCityTest() {
		Office office = new Office();
		
		office.setOfficeCode(1L);
		office.setAddressLine1("Gaya, Bihar");
		office.setCity("Gaya");
		office.setState("Bihar");
		office.setCountry("India");
		office.setPostalCode("432010");
		
		Mockito.when(officeRepository.save(office)).
		thenReturn(office);
		assertThat(officeService.getOfficeSortedByCity()).
		isNotNull();
	}
	
	@Test
	public void getOfficeSortedByCountryUsingTest() {
		Office office = new Office();
		
		office.setOfficeCode(1L);
		office.setAddressLine1("Gaya, Bihar");
		office.setCity("Gaya");
		office.setState("Bihar");
		office.setCountry("India");
		office.setPostalCode("432010");
		
		Mockito.when(officeRepository.save(office)).
		thenReturn(office);
		assertThat(officeService.getOfficeSortedByCountryUsingNative()).
		isNotNull();
	}
	
	@Test
	public void getOfficeByCountryTest() {
		Office office = new Office();
		
		office.setOfficeCode(1L);
		office.setAddressLine1("Gaya, Bihar");
		office.setCity("Gaya");
		office.setState("Bihar");
		office.setCountry("India");
		office.setPostalCode("432010");
		
		Mockito.when(officeRepository.save(office)).
		thenReturn(office);
		assertThat(officeService.getOfficeByCountry("India")).
		isNotNull();
	}
	
	@Test
	public void getOfficesUsingPagingTest() {
		Office office = new Office();
		
		office.setOfficeCode(1L);
		office.setAddressLine1("Gaya, Bihar");
		office.setCity("Gaya");
		office.setState("Bihar");
		office.setCountry("India");
		office.setPostalCode("432010");
		
		Mockito.when(officeRepository.save(office)).
		thenReturn(office);
		assertThat(officeService.getOfficesUsingPaging()).
		isNotNull();
	}
	
	@Test
	public void getSortOfficesUsingSortingTest() {
		Office office = new Office();
		
		office.setOfficeCode(1L);
		office.setAddressLine1("Gaya, Bihar");
		office.setCity("Gaya");
		office.setState("Bihar");
		office.setCountry("India");
		office.setPostalCode("432010");
		
		Mockito.when(officeRepository.save(office)).
		thenReturn(office);
		assertThat(officeService.getSortOfficesUsingSorting()).
		isNotNull();
	}

	
}
