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

import com.shoppingcart.app.exception.OrderDetailNotFoundException;
import com.shoppingcart.app.model.OrderDetail;
import com.shoppingcart.app.service.OrderDetailService;

@RestController
@RequestMapping("/api/v1/")
public class OrderDetailController {
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	//get all OrderDetail handler
	@GetMapping("orderdetails")
	public ResponseEntity<List<OrderDetail>> getAllOrderDetails() throws OrderDetailNotFoundException {
		List<OrderDetail> orderDetail = orderDetailService.getAllOrderDetails();
		
		if(orderDetail.size()<=0) {
			throw new OrderDetailNotFoundException("OrderDetail not exist");
		}
		return ResponseEntity.of(Optional.of(orderDetail));
	}

	//get single OrderDetail handler
	@GetMapping("orderdetails/{id}")
	public ResponseEntity<OrderDetail> getOrderDetail(@PathVariable("id") Long id) throws OrderDetailNotFoundException  {
		OrderDetail orderDetail = orderDetailService.getOrderDetailById(id)
				 .orElseThrow(() -> new OrderDetailNotFoundException("OrderDetail not exist with id:" + id));
		
		if(orderDetail == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(orderDetail));
	}
	
	//new OrderDetail handler
	@PostMapping("orderdetails")
	public ResponseEntity<OrderDetail> addOrderDetails(@RequestBody OrderDetail orderDetail) throws OrderDetailNotFoundException {
		OrderDetail o = orderDetailService.addOrderDetail(orderDetail);
		
		if(o == null) {
			throw new OrderDetailNotFoundException("OrderDetail not get inserted");
		}
		return ResponseEntity.of(Optional.of(o));
	}
	
	//delete OrderDetail handler
	@DeleteMapping("orderdetails/{orderdetailId}")
	public ResponseEntity<Void> deleteOrderDetail(@PathVariable("orderdetailId") Long orderdetailId) throws OrderDetailNotFoundException {
		
		orderDetailService.getOrderDetailById(orderdetailId)
				 .orElseThrow(() -> new OrderDetailNotFoundException("OrderDetail not exist with id:" + orderdetailId));
		
		orderDetailService.deleteOrderDetail(orderdetailId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	//update OrderDetail handler
	@PutMapping("orderdetails/{orderDetailId}")
	public ResponseEntity<OrderDetail> updateOrderDetails(@RequestBody OrderDetail orderDetail, @PathVariable("orderDetailId") Long orderDetailId) throws OrderDetailNotFoundException {
		
		orderDetailService.getOrderDetailById(orderDetailId)
				 .orElseThrow(() -> new OrderDetailNotFoundException("OrderDetail not exist with id:" + orderDetailId));
		
		orderDetailService.updateOrderDetail(orderDetail, orderDetailId);
		
		return ResponseEntity.ok(orderDetail);
		
	}

	//get all OrderDetail handler sorted by quantity using query
	@GetMapping("orderdetails/sort")
	public ResponseEntity<List<OrderDetail>> getOrderDetailSortedByQuantity() throws OrderDetailNotFoundException {
		List<OrderDetail> orderDetail = orderDetailService.getOrderDetailSortedByQuantity();
			
		if(orderDetail.size()<=0) {
			throw new OrderDetailNotFoundException("OrderDetail not exists ");
		}
		return ResponseEntity.of(Optional.of(orderDetail));
	}
		
	//get all OrderDetail handler sorted by price each using native query
	@GetMapping("orderdetails/sort/native")
	public ResponseEntity<List<OrderDetail>> getOrderDetailSortedByPriceEachUsingNative() throws OrderDetailNotFoundException {
		List<OrderDetail> orderDetail = orderDetailService.getOrderDetailSortedByPriceEachUsingNative();
			
		if(orderDetail.size()<=0) {
			throw new OrderDetailNotFoundException("OrderDetail not exists ");
		}
		return ResponseEntity.of(Optional.of(orderDetail));
	}

	//get all OrderDetail handler by quantity
	@GetMapping("orderdetails/ordered/{quantityOrdered}")
	public ResponseEntity<List<OrderDetail>> getAllOrderDetailByQuantityOrdered(@PathVariable("quantityOrdered") int quantityOrdered) throws OrderDetailNotFoundException {
		List<OrderDetail> orderDetail = orderDetailService.getAllOrderDetailByQuantityOrdered(quantityOrdered);
		
		if(orderDetail.size()<=0) {
			throw new OrderDetailNotFoundException("OrderDetail not exist with quantityOrdered: " + quantityOrdered);
		}
		return ResponseEntity.of(Optional.of(orderDetail));
	}
	
	//implementing paging
	@GetMapping("orderdetails/paging")
	public ResponseEntity<List<OrderDetail>> getOrderDetails() throws OrderDetailNotFoundException {
		List<OrderDetail> orderDetail = orderDetailService.getOrderDetailsUsingPaging();
		
		if(orderDetail.size()<=0) {
			throw new OrderDetailNotFoundException("OrderDetail not exist");
		}
		return ResponseEntity.of(Optional.of(orderDetail));
	}

	//sorting implementation
	@GetMapping("orderdetails/sorting")
	public ResponseEntity<Iterable<OrderDetail>> getSortOrderDetails() throws OrderDetailNotFoundException {
		List<OrderDetail> orderDetail = (List<OrderDetail>) orderDetailService.getSortOrderDetailsUsingSorting();
		
		if(orderDetail.size()<=0) {
			throw new OrderDetailNotFoundException("OrderDetail not exist");
		}
		return ResponseEntity.of(Optional.of(orderDetail));
	}
	
}
