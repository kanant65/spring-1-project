package com.shoppingcart.app.service;

import java.util.List;
import java.util.Optional;

import com.shoppingcart.app.model.Order;

public interface OrderService {
	
	public List<Order> getAllOrders();
	
	public Optional<Order> getOrderById(Long id);
	
	public Order addOrder(Order order);
	
	public void deleteOrder(Long oid);
	
	public void updateOrder(Order order, Long orderId);
	
	public List<Order> getAllByStatusTrue();
	
	public List<Order> getOrderSortedByCommentUsingNative();
	
	public List<Order> getOrdersUsingPaging();
	
	public Iterable<Order> getSortOrdersUsingSorting();
	
}
