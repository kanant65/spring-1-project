package com.shoppingcart.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "offices")
public class Office {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "office_code")
	private Long officeCode;
	
	@Column(name = "city", nullable = false, length = 255)
	private String city;
	
	@Column(name = "phone", nullable = false, length = 255)
	private String phone;
	
	@Column(name = "address_line1", nullable = false, length = 255)
	private String addressLine1;
	
	@Column(name = "address_line2", nullable = false, length = 255)
	private String addressLine2;
	
	@Column(name = "state", nullable = false, length = 255)
	private String state;
	
	@Column(name = "country", nullable = false, length = 255)
	private String country;
	
	@Column(name = "postal_code", nullable = false, length = 255)
	private String postalCode;
	
	@Column(name = "teritory", nullable = false, length = 255)
	private String teritory;
	
	@OneToMany
	@JoinColumn(name = "office_officecode")
	private List<Employee> employee;

	public Office() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Office(Long officeCode, String city, String phone, String addressLine1, String addressLine2, String state,
			String country, String postalCode, String teritory, List<Employee> employee) {
		super();
		this.officeCode = officeCode;
		this.city = city;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.teritory = teritory;
		this.employee = employee;
	}

	public Office(String city, String phone, String addressLine1, String addressLine2, String state, String country,
			String postalCode, String teritory, List<Employee> employee) {
		super();
		this.city = city;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.teritory = teritory;
		this.employee = employee;
	}

	public Long getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(Long officeCode) {
		this.officeCode = officeCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getTeritory() {
		return teritory;
	}

	public void setTeritory(String teritory) {
		this.teritory = teritory;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Office [officeCode=" + officeCode + ", city=" + city + ", phone=" + phone + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", state=" + state + ", country=" + country
				+ ", postalCode=" + postalCode + ", teritory=" + teritory + ", employee=" + employee + "]";
	}
}

