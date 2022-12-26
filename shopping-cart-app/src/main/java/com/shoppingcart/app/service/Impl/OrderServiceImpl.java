package com.shoppingcart.app.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.model.Order;
import com.shoppingcart.app.repository.OrderRepository;
import com.shoppingcart.app.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	//get all Orders
	public List<Order> getAllOrders(){
		List<Order> list = orderRepository.findAll();
		return list;
	}
	
	//get single Order by id
	public Optional<Order> getOrderById(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		return order;
	}
	
	//adding the Order
	public Order addOrder(Order order) {
		Order result = orderRepository.save(order);
		return result;
	}
	
	//delete Order by id
	public void deleteOrder(Long oid) {
		orderRepository.deleteById(oid);
	}
	
	//update Order
	public void updateOrder(Order order, Long orderId) {
		order.setOrderNumber(orderId);
		orderRepository.save(order);
	}
	
	//get all Orders by status true using query
	@Override
	public List<Order> getAllByStatusTrue() {
		List<Order> list = orderRepository.findAllByStatusTrue();
		return list;
	}

	//get all Orders sorted by comments using native query
	@Override
	public List<Order> getOrderSortedByCommentUsingNative() {
		List<Order> list = orderRepository.findAllSortedByCommentUsingNative();
		return list;
	}

	//get all Orders by using paging concept
	@Override
	public List<Order> getOrdersUsingPaging() {
		Pageable pageable = PageRequest.of(0, 2);
		List<Order> list = orderRepository.findOrders(pageable);
		return list;
	}

	//get all Orders in a sort order of orderDate using concept of Sorting
	@Override
	public Iterable<Order> getSortOrdersUsingSorting() {
		String sortBy = "orderNumber";
		List<Order> list = (List<Order>) orderRepository.sortOrder(Sort.by(Sort.Direction.ASC,sortBy));
		return list;
	}

}
