package shopping.cart.demo.model;

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

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productcode")
	private Long productCode;
	
	@Column(name = "product_name", nullable = false, length = 255)
	private String productName;
	
	@Column(name = "product_scale", nullable = false, length = 255)
	private String productScale;
	
	@Column(name = "product_vendor", nullable = false, length = 255)
	private String productVendor;
	
	@Column(name = "product_description", nullable = false, length = 255)
	private String productDescription;
	
	@Column(name = "quabtity_in_stock")
	private Long quantityInStock;
	
	@Column(name = "buy_price")
	private double buyPrice;
	
	@Column(name = "msrp")
	private double msrp;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderDetail_productCode")
	private OrderDetail orderDetail;
	
	@ManyToOne
	@JoinColumn(name = "productlines_productline")
	private ProductLine productline;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long productCode, String productName, ProductLine productline, String productScale,
			String productVendor, String productDescription, Long quantityInStock, double buyPrice, double msrp,
			OrderDetail orderDetail) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productline = productline;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescription = productDescription;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		this.msrp = msrp;
		this.orderDetail = orderDetail;
	}

	public Product(String productName, ProductLine productline, String productScale, String productVendor,
			String productDescription, Long quantityInStock, double buyPrice, double msrp, OrderDetail orderDetail) {
		super();
		this.productName = productName;
		this.productline = productline;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescription = productDescription;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		this.msrp = msrp;
		this.orderDetail = orderDetail;
	}

	public Long getProductCode() {
		return productCode;
	}

	public void setProductCode(Long productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProductLine getProductline() {
		return productline;
	}

	public void setProductline(ProductLine productline) {
		this.productline = productline;
	}

	public String getProductScale() {
		return productScale;
	}

	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}

	public String getProductVendor() {
		return productVendor;
	}

	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Long getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(Long quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public double getMsrp() {
		return msrp;
	}

	public void setMsrp(double msrp) {
		this.msrp = msrp;
	}

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productline=" + productline
				+ ", productScale=" + productScale + ", productVendor=" + productVendor + ", productDescription="
				+ productDescription + ", quantityInStock=" + quantityInStock + ", buyPrice=" + buyPrice + ", msrp="
				+ msrp + ", orderDetail=" + orderDetail + "]";
	}
}

