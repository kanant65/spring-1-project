package shopping.cart.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetails")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_number")
	private Long orderNumber;
	
	@Column(name = "quantity_ordered")
	private int quantityOrdered;
	
	@Column(name = "price_each")
	private double priceEach;
	
	@Column(name = "order_line_number")
	private int orderLineNumber;

	@OneToOne
	@JoinColumn(name = "orderDetail_productCode")
	private Product productCode;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy ="orderdetails")
	@JoinColumn(name = "OrderDetail_orderNumber")
	private Order orders;

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(Long orderNumber, int quantityOrdered, double priceEach, int orderLineNumber,
			Product productCode, Order orders) {
		super();
		this.orderNumber = orderNumber;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
		this.productCode = productCode;
		this.orders = orders;
	}

	public OrderDetail(int quantityOrdered, double priceEach, int orderLineNumber, Product productCode, Order orders) {
		super();
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
		this.productCode = productCode;
		this.orders = orders;
	}

	public Long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public double getPriceEach() {
		return priceEach;
	}

	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}

	public int getOrderLineNumber() {
		return orderLineNumber;
	}

	public void setOrderLineNumber(int orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}

	public Product getProductCode() {
		return productCode;
	}

	public void setProductCode(Product productCode) {
		this.productCode = productCode;
	}

	public Order getOrders() {
		return orders;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderNumber=" + orderNumber + ", quantityOrdered=" + quantityOrdered + ", priceEach="
				+ priceEach + ", orderLineNumber=" + orderLineNumber + ", productCode=" + productCode + ", orders="
				+ orders + "]";
	}
	
}
