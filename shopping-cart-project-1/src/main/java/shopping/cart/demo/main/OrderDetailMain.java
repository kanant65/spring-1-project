package shopping.cart.demo.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import shopping.cart.demo.controller.OrderDetailController;
import shopping.cart.demo.exception.OrderDetailNotFoundException;
import shopping.cart.demo.model.OrderDetail;

@Controller
public class OrderDetailMain {

	@Autowired
	private OrderDetailController orderDetailController;
	
	public void oderDetailRun() {
		System.out.println("\n OrderDetail Entity records :");
		addOrderDetails(createOrderDetails());
	}

	//method to add OrderDetail
	private void addOrderDetails(List<OrderDetail> orderDetails) {
		for(OrderDetail orderDetail : orderDetails) {
			try {
				orderDetailController.addOrderDetails(orderDetail);
			} 
			catch (OrderDetailNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//method to create List of OrderDetail
	private List<OrderDetail> createOrderDetails(){
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		
		OrderDetail od1 = new OrderDetail(500, 40.08,   1, null, null);
		OrderDetail od2 = new OrderDetail(10,  125.00,  2, null, null);
		OrderDetail od3 = new OrderDetail(20,  2529.07, 4, null, null);
		OrderDetail od4 = new OrderDetail(60,  20.08,   5, null, null);
		OrderDetail od5 = new OrderDetail(17,  1500.07, 3, null, null);
		OrderDetail od6 = new OrderDetail(10,  70080.90,6, null, null);
		OrderDetail od7 = new OrderDetail(12,  750.07,  8, null, null);
		OrderDetail od8 = new OrderDetail(100, 2529.07, 7, null, null);
	
		orderDetails.add(od1);
		orderDetails.add(od2);
		orderDetails.add(od3);
		orderDetails.add(od4);
		orderDetails.add(od5);
		orderDetails.add(od6);
		orderDetails.add(od7);
		orderDetails.add(od8);
		
		return orderDetails;
	}

}
