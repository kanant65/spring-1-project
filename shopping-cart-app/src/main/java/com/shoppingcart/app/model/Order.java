package com.shoppingcart.app.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_number")
	private Long orderNumber;
	
	@CreationTimestamp
	@Column(name = "order_date")
	private Date orderDate;
	
	@CreationTimestamp
	@Column(name = "required_date")
	private Date requiredDate;
	
	@CreationTimestamp
	@Column(name = "shipped_date")
	private Date shippedDate;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "comments")
	private String comments;
	
	@ManyToOne
	@JoinColumn(name = "customers_customernumber")
	private Customer customerNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "OrderDetail_orderNumber")
	private OrderDetail orderdetails;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Long orderNumber, Date orderDate, Date requiredDate, Date shippedDate, boolean status, String comments,
			Customer customerNumber, OrderDetail orderdetails) {
		super();
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.status = status;
		this.comments = comments;
		this.customerNumber = customerNumber;
		this.orderdetails = orderdetails;
	}

	public Order(Date orderDate, Date requiredDate, Date shippedDate, boolean status, String comments,
			Customer customerNumber, OrderDetail orderdetails) {
		super();
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.status = status;
		this.comments = comments;
		this.customerNumber = customerNumber;
		this.orderdetails = orderdetails;
	}

	public Long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	public Date getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Customer getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Customer customerNumber) {
		this.customerNumber = customerNumber;
	}

	public OrderDetail getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(OrderDetail orderdetails) {
		this.orderdetails = orderdetails;
	}

	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", requiredDate=" + requiredDate
				+ ", shippedDate=" + shippedDate + ", status=" + status + ", comments=" + comments + ", customerNumber="
				+ customerNumber + ", orderdetails=" + orderdetails + "]";
	}

}
