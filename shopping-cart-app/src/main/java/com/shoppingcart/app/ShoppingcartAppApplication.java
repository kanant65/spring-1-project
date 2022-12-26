package com.shoppingcart.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shoppingcart.app.main.CustomerMain;
import com.shoppingcart.app.main.EmployeeMain;
import com.shoppingcart.app.main.OfficeMain;
import com.shoppingcart.app.main.OrderDetailMain;
import com.shoppingcart.app.main.OrderMain;
import com.shoppingcart.app.main.PaymentMain;
import com.shoppingcart.app.main.ProductLineMain;
import com.shoppingcart.app.main.ProductMain;

@SpringBootApplication
public class ShoppingcartAppApplication implements CommandLineRunner {

	@Autowired
	private ProductMain productMain;
	
	@Autowired
	private ProductLineMain productLineMain;
	
	@Autowired
	private OrderDetailMain orderDetailMain;
	
	@Autowired
	private OrderMain orderMain;
	
	@Autowired
	private PaymentMain paymentMain;
	
	@Autowired
	private CustomerMain customerMain;
	
	@Autowired
	private EmployeeMain employeeMain;
	
	@Autowired
	private OfficeMain officeMain;

	public static void main(String[] args)  {
		SpringApplication.run(ShoppingcartAppApplication.class, args);
			
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("\n\n******************************ProductLine Entity*****************************\n");
		productLineMain.productLineRun();
		
		System.out.println("\n\n*********************************Product Entity*******************************\n");
		productMain.productRun();

		System.out.println("\n\n*********************************Product Entity*******************************\n");
		orderDetailMain.oderDetailRun();
		
		System.out.println("\n\n*********************************Product Entity*******************************\n");
		orderMain.orderRun();
		
		System.out.println("\n\n*********************************Payment Entity*******************************\n");
		paymentMain.paymentRun();
		
		System.out.println("\n\n*********************************Customer Entity*******************************\n");
		customerMain.customerRun();
		
		System.out.println("\n\n*********************************Employee Entity*******************************\n");
		employeeMain.employeeRun();
		
		System.out.println("\n\n*********************************Office Entity*******************************\n");
		officeMain.officeRun();

	}

}
