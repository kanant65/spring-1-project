package shopping.cart.demo.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shopping.cart.demo.exception.OrderNotFoundException;
import shopping.cart.demo.model.Order;
import shopping.cart.demo.repository.OrderRepository;

@RestController
@RequestMapping("/api/v1/")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
	//get all Order handler
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getOrders() throws OrderNotFoundException {
		List<Order> list = orderRepository.findAll();
		
		if(list.size()<=0) {
			throw new OrderNotFoundException("Order not exist");
		}
		return ResponseEntity.of(Optional.of(list));
	}

	//get single Order handler
	@GetMapping("/orders/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable("id") Long id) throws OrderNotFoundException  {
		Order order = orderRepository.findById(id)
				 .orElseThrow(() -> new OrderNotFoundException("Order not exist with id:" + id));
		
		if(order == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(order));
	}
	
	//new Order handler
	@PostMapping("/orders")
	public ResponseEntity<Order> addOrder(@RequestBody Order order) throws OrderNotFoundException {
		Order o = orderRepository.save(order);
		
		if(orderRepository.save(order) == null) {
			throw new OrderNotFoundException("Order not get inserted");
		}
		return ResponseEntity.of(Optional.of(o));
	}
	
	//delete Order handler
	@DeleteMapping("/orders/{orderId}")
	public ResponseEntity<Void> deleteOrder(@PathVariable("orderId") Long orderId) throws OrderNotFoundException {
		
		Order order = orderRepository.findById(orderId)
				 .orElseThrow(() -> new OrderNotFoundException("Order not exist with id:" + orderId));
		
		orderRepository.delete(order);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	//update Order handler
	@PutMapping("/orders/{orderId}")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable("orderId") Long orderId) throws OrderNotFoundException {
		
		Order updateOrder = orderRepository.findById(orderId)
				 .orElseThrow(() -> new OrderNotFoundException("Order not exist with id:" + orderId));
		
		updateOrder.setOrderNumber(orderId);
		orderRepository.save(order);
		
		return ResponseEntity.ok(updateOrder);
	}
	
	//get all Order handler sorted by status
	@GetMapping("orders/sort")
	public ResponseEntity<List<Order>> getOrderSortedByStatus() throws OrderNotFoundException {
		List<Order> list = orderRepository.findAllByStatusTrue();
			
		if(list.size()<=0) {
			throw new OrderNotFoundException("Order not exists ");
		}
		return ResponseEntity.of(Optional.of(list));
	}
		
	//get all Order handler sorted by comments using native
	@GetMapping("orders/sort/native")
	public ResponseEntity<List<Order>> getOrderSortedByCommentUsingNative() throws OrderNotFoundException {
		List<Order> list = orderRepository.findAllSortedByCommentUsingNative();
			
		if(list.size()<=0) {
			throw new OrderNotFoundException("Order not exists ");
		}
		return ResponseEntity.of(Optional.of(list));
	}	
	
	//get single Order handler by comment
	@GetMapping("orders/comments")
	public ResponseEntity<Order> getOrderByCode(@RequestParam String comments) throws OrderNotFoundException{
		Order order = orderRepository.findByComments(comments);
		
		if(order == null) {
			throw new OrderNotFoundException("Order not exists with comments : " + comments);
		}
		return ResponseEntity.of(Optional.of(order));
	}
}
