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
import org.springframework.web.bind.annotation.RestController;

import shopping.cart.demo.exception.OrderDetailNotFoundException;
import shopping.cart.demo.model.OrderDetail;
import shopping.cart.demo.repository.OrderDetailRepository;

@RestController
@RequestMapping("/api/v1/")
public class OrderDetailController {
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	//get all OrderDetail handler
	@GetMapping("/orderdetails")
	public ResponseEntity<List<OrderDetail>> getAllOrderDetails() throws OrderDetailNotFoundException {
		List<OrderDetail> list = orderDetailRepository.findAll();
		
		if(list.size()<=0) {
			throw new OrderDetailNotFoundException("OrderDetail not exist");
		}
		return ResponseEntity.of(Optional.of(list));
	}

	//get single OrderDetail handler
	@GetMapping("/orderdetails/{id}")
	public ResponseEntity<OrderDetail> getOrderDetail(@PathVariable("id") Long id) throws OrderDetailNotFoundException  {
		OrderDetail orderDetail = orderDetailRepository.findById(id)
				 .orElseThrow(() -> new OrderDetailNotFoundException("OrderDetail not exist with id:" + id));
		
		if(orderDetail == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(orderDetail));
	}
	
	//new OrderDetail handler
	@PostMapping("/orderdetails")
	public ResponseEntity<OrderDetail> addOrderDetails(@RequestBody OrderDetail orderDetail) throws OrderDetailNotFoundException {
		OrderDetail o = orderDetailRepository.save(orderDetail);
		
		if(orderDetailRepository.save(orderDetail) == null) {
			throw new OrderDetailNotFoundException("OrderDetail not get inserted");
		}
		return ResponseEntity.of(Optional.of(o));
	}
	
	//delete OrderDetail handler
	@DeleteMapping("/orderdetails/{orderdetailId}")
	public ResponseEntity<Void> deleteOrderDetails(@PathVariable("orderdetailId") Long orderdetailId) throws OrderDetailNotFoundException {
		
		OrderDetail orderDetail = orderDetailRepository.findById(orderdetailId)
				 .orElseThrow(() -> new OrderDetailNotFoundException("OrderDetail not exist with id:" + orderdetailId));
		
		orderDetailRepository.delete(orderDetail);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	//update OrderDetail handler
	@PutMapping("/orderdetails/{orderDetailId}")
	public ResponseEntity<OrderDetail> updateOrderDetails(@RequestBody OrderDetail orderDetail, @PathVariable("orderDetailId") Long orderDetailId) throws OrderDetailNotFoundException {
		
		OrderDetail updateOrderdetail = orderDetailRepository.findById(orderDetailId)
				 .orElseThrow(() -> new OrderDetailNotFoundException("OrderDetail not exist with id:" + orderDetailId));
		
		updateOrderdetail.setOrderNumber(orderDetailId);
		orderDetailRepository.save(orderDetail);
		
		return ResponseEntity.ok(updateOrderdetail);
		
	}

	//get all OrderDetail handler sorted by quantity
	@GetMapping("orderdetails/sort")
	public ResponseEntity<List<OrderDetail>> getOrderDetailSortedByQuantity() throws OrderDetailNotFoundException {
		List<OrderDetail> list = orderDetailRepository.findAllSortedByQuantity();
			
		if(list.size()<=0) {
			throw new OrderDetailNotFoundException("OrderDetail not exists ");
		}
		return ResponseEntity.of(Optional.of(list));
	}
		
	//get all OrderDetail handler sorted by quantity using native
	@GetMapping("orderdetails/sort/native")
	public ResponseEntity<List<OrderDetail>> getOrderDetailSortedByQuantityUsingNative() throws OrderDetailNotFoundException {
		List<OrderDetail> list = orderDetailRepository.findAllSortedByQuantityUsingNative();
			
		if(list.size()<=0) {
			throw new OrderDetailNotFoundException("OrderDetail not exists ");
		}
		return ResponseEntity.of(Optional.of(list));
	}	
}
