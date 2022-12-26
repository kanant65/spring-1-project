package com.shoppingcart.app.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shoppingcart.app.controller.OrderController;
import com.shoppingcart.app.exception.OrderNotFoundException;
import com.shoppingcart.app.model.Order;

@Controller
public class OrderMain {
	
	@Autowired
	private OrderController orderController;
	
	public void orderRun() {
		System.out.println("\n Order Entity records :");
		addOrders(createOrders());
	}

	//method to add Order
	private void addOrders(List<Order> orders) {
		for(Order order : orders) {
			try {
				orderController.addOrder(order);
			} 
			catch (OrderNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//method to create List of Order
	private List<Order> createOrders(){
		List<Order> orders = new ArrayList<Order>();
		
		Order o1 = new Order(new Date(2022, 11, 10), new Date(2022, 11, 25), new Date(2022, 11, 22), true, "Shipped",
				null, null);
		Order o2 = new Order(new Date(2022, 12, 1), new Date(2022, 12, 5), new Date(2022, 12, 8), true, "Delivered",
				null, null);
		Order o3 = new Order(new Date(2022, 10, 20), new Date(2022, 10, 30), new Date(2022, 11, 2), true, "Received",
				null, null);
		Order o4 = new Order(new Date(2022, 11, 8), new Date(2022, 11, 19), new Date(2022, 11, 20), true, "Cancelled",
				null, null);
		Order o5 = new Order(new Date(2022, 12, 3), new Date(2022, 12, 03), new Date(2022, 12, 3), true, "Order Confirmed",
				null, null);
		Order o6 = new Order(new Date(2022, 12, 4), new Date(2022, 12, 6), new Date(2022, 12, 8), true, "Out for Delivery",
				null, null);
		Order o7 = new Order(new Date(2022, 12, 10), new Date(2022, 12, 12), new Date(2022, 12, 14), true, "Order Confirmed",
				null, null);
		Order o8 = new Order(new Date(2022, 12, 1), new Date(2022, 12, 3), new Date(2022, 12, 4), true, "Cancelled",
				null, null);
	
		orders.add(o1);
		orders.add(o2);
		orders.add(o3);
		orders.add(o4);
		orders.add(o5);
		orders.add(o6);
		orders.add(o7);
		orders.add(o8);
		
		return orders;
	}

}
