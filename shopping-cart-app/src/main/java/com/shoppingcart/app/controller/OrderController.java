package com.shoppingcart.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.app.exception.OrderNotFoundException;
import com.shoppingcart.app.model.Order;
import com.shoppingcart.app.service.OrderService;

@RestController
@RequestMapping("/api/v1/")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	//get all Order handler
	@GetMapping("orders")
	public ResponseEntity<List<Order>> getAllOrders() throws OrderNotFoundException {
		List<Order> order = orderService.getAllOrders();
		
		if(order.size()<=0) {
			throw new OrderNotFoundException("Orders record is empty");
		}
		return ResponseEntity.of(Optional.of(order));
	}

	//get single Order handler by id
	@GetMapping("orders/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable("id") Long id) throws OrderNotFoundException  {
		Order order = orderService.getOrderById(id)
				 .orElseThrow(() -> new OrderNotFoundException("Order not exist with id:" + id));
		
		if(order == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(order));
	}
	
	//new Order handler
	@PostMapping("orders")
	public ResponseEntity<Order> addOrder(@RequestBody Order order) throws OrderNotFoundException {
		Order o = orderService.addOrder(order);
		
		if(o == null) {
			throw new OrderNotFoundException("Order not get inserted");
		}
		return ResponseEntity.of(Optional.of(o));
	}
	
	//delete Order handler
	@DeleteMapping("orders/{orderId}")
	public ResponseEntity<Void> deleteOrder(@PathVariable("orderId") Long orderId) throws OrderNotFoundException {
		
		orderService.getOrderById(orderId)
			.orElseThrow(() -> new OrderNotFoundException("Order not exist with id:" + orderId));
		
		orderService.deleteOrder(orderId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	//update Order handler
	@PutMapping("orders/{orderId}")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable("orderId") Long orderId) throws OrderNotFoundException {
		
		orderService.getOrderById(orderId)
			.orElseThrow(() -> new OrderNotFoundException("Order not exist with id:" + orderId));
		
		orderService.updateOrder(order, orderId);
		
		return ResponseEntity.ok().body(order);
	}
	
	//get all Order handler by status true using query
	@GetMapping("orders/sort")
	public ResponseEntity<List<Order>> getAllByStatusTrue() throws OrderNotFoundException {
		List<Order> order = orderService.getAllByStatusTrue();
			
		if(order.size()<=0) {
			throw new OrderNotFoundException("Order not exists ");
		}
		return ResponseEntity.of(Optional.of(order));
	}
		
	//get all Order handler sorted by comments using native
	@GetMapping("orders/sort/native")
	public ResponseEntity<List<Order>> getOrderSortedByCommentUsingNative() throws OrderNotFoundException {
		List<Order> order = orderService.getOrderSortedByCommentUsingNative();
			
		if(order.size()<=0) {
			throw new OrderNotFoundException("Order not exists ");
		}
		return ResponseEntity.of(Optional.of(order));
	}	
	
	//implementing paging
	@GetMapping("orders/paging")
	public ResponseEntity<List<Order>> getOrders() throws OrderNotFoundException{
		List<Order> order = orderService.getOrdersUsingPaging();
		
		if(order.size()<=0) {
			throw new OrderNotFoundException("Order not exist");
		}
		return new ResponseEntity<List<Order>>(orderService.getOrdersUsingPaging(), HttpStatus.OK);
	}

	//sorting implementation
	@GetMapping("orders/sorting")
	public ResponseEntity<Iterable<Order>> getSortOrders() throws OrderNotFoundException {
		List<Order> order = (List<Order>) orderService.getSortOrdersUsingSorting();
		
		if(order.size()<=0) {
			throw new OrderNotFoundException("Order not exist");
		}
		return ResponseEntity.of(Optional.of(order));
	}
	
}
