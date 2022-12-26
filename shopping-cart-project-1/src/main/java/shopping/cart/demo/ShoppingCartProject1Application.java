package shopping.cart.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import shopping.cart.demo.main.CustomerMain;
import shopping.cart.demo.main.EmployeeMain;
import shopping.cart.demo.main.OfficeMain;
import shopping.cart.demo.main.OrderDetailMain;
import shopping.cart.demo.main.OrderMain;
import shopping.cart.demo.main.PaymentMain;
import shopping.cart.demo.main.ProductLineMain;
import shopping.cart.demo.main.ProductMain;

@SpringBootApplication
public class ShoppingCartProject1Application implements CommandLineRunner {
	
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

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartProject1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Enter Your Choice to get Records :  ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("\n PRESS 1 to get Products Records");
			System.out.println("\n PRESS 2 to get ProductLines Records");
			System.out.println("\n PRESS 3 to get OrderDetails Records");
			System.out.println("\n PRESS 4 to get Orders Records");
			System.out.println("\n PRESS 5 to get Payments Records");
			System.out.println("\n PRESS 6 to get Customers Records");
			System.out.println("\n PRESS 7 to get Employees Records");
			System.out.println("\n PRESS 8 to get Offices Records");
			System.out.println("\n PRESS 9 to Exit");
			
			int c = Integer.parseInt(br.readLine());
			
			if(c==1) {
				System.out.println("\n\n***********************************************************\n");
				System.out.println("\n Product Entity Records as per the sequence :  ");
				productMain.productRun();
			}
			
			else if(c==2) {
				System.out.println("\n\n***********************************************************\n");
				System.out.println("\n ProductLine Entity Records as per the sequence :  ");
				productLineMain.productLineRun();
			}
			
			else if(c==3) {
				System.out.println("\n\n***********************************************************\n");
				System.out.println("\n OrderDetail Entity Records as per the sequence :  ");
				orderDetailMain.oderDetailRun();
				
			}
			
			else if(c==4){
				System.out.println("\n\n***********************************************************\n");
				System.out.println("\n Order Entity Records as per the sequence :  ");
				orderMain.orderRun();
			}
			
			else if(c==5){
				System.out.println("\n\n***********************************************************\n");
				System.out.println("\n Payment Entity Records as per the sequence :  ");
				paymentMain.paymentRun();
			}
			
			else if(c==6){
				System.out.println("\n\n***********************************************************\n");
				System.out.println("\n Customer Entity Records as per the sequence :  ");
				customerMain.customerRun();
			}
			
			else if(c==7){
				System.out.println("\n\n***********************************************************\n");
				System.out.println("\n Employee Entity Records as per the sequence :  ");
				employeeMain.employeeRun();
			}
			
			else if(c==8){
				System.out.println("\n\n***********************************************************\n");
				System.out.println("\n Office Entity Records as per the sequence :  ");
				officeMain.officeRun();
			}
			
			else if(c==9) {
				System.out.println("\n\n***********************************************************\n");
				System.out.println("\n Have a wonderful day. ");
				break;
			}
			
			else {
				System.out.println("\n Wrong Input !");
			}
				
		}
		
	}

}
