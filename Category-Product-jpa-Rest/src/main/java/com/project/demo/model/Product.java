/*
 
product
	id int(11) unsigned not null, and the same column is the primary key
	name nvarchar(50) not null
	price double not null
	unitsInStock int (at present how many units are there?)
	discontinued bool(whether the product is still doing business or not)
	category_id int(11) (foreign key to categories(id)) 
 */
package com.project.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, length = 11)
	private int id;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "price", nullable = false)
	private double price;
	
	@Column(name = "unitsInStock")
	private int unitsInStock;
	
	@Column(name = "discontinued")
	private boolean discontinued;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category categoryId;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String name, double price, int unitsInStock, boolean discontinued, Category categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.unitsInStock = unitsInStock;
		this.discontinued = discontinued;
		this.categoryId = categoryId;
	}

	public Product(String name, double price, int unitsInStock, boolean discontinued, Category categoryId) {
		super();
		this.name = name;
		this.price = price;
		this.unitsInStock = unitsInStock;
		this.discontinued = discontinued;
		this.categoryId = categoryId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}

	public Category getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", unitsInStock=" + unitsInStock
				+ ", discontinued=" + discontinued + ", categoryId=" + categoryId + "]";
	}

}
