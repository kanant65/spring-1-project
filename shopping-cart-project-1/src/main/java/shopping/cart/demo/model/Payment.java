package shopping.cart.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "payments")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "check_number")
	private Long checkNumber;
	
	@CreationTimestamp
	@Column(name = "payment_date")
	private Date paymentDate;
	
	@Column(name = "amount")
	private double amount;
	
	@OneToOne
	@JoinColumn(name = "payment_customernumber")
	private Customer customerLine;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(Long checkNumber, Date paymentDate, double amount, Customer customerLine) {
		super();
		this.checkNumber = checkNumber;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.customerLine = customerLine;
	}

	public Payment(Date paymentDate, double amount, Customer customerLine) {
		super();
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.customerLine = customerLine;
	}

	public Long getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(Long checkNumber) {
		this.checkNumber = checkNumber;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Customer getCustomerLine() {
		return customerLine;
	}

	public void setCustomerLine(Customer customerLine) {
		this.customerLine = customerLine;
	}

	@Override
	public String toString() {
		return "Payment [checkNumber=" + checkNumber + ", paymentDate=" + paymentDate + ", amount=" + amount
				+ ", customerLine=" + customerLine + "]";
	}
	
}
