package com.shoppingcart.app.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.model.OrderDetail;
import com.shoppingcart.app.repository.OrderDetailRepository;
import com.shoppingcart.app.service.OrderDetailService;
@Service
public class OrderDetailServiceImpl implements OrderDetailService{

	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	//get all OrderDetails
	public List<OrderDetail> getAllOrderDetails(){
		List<OrderDetail> list = orderDetailRepository.findAll();
		return list;
	}
	
	//get single OrderDetail by id
	public Optional<OrderDetail> getOrderDetailById(Long orderDetailId) {
		Optional<OrderDetail> orderDetail = orderDetailRepository.findById(orderDetailId);
		return orderDetail;
	}
	
	//adding the OrderDetail
	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
		OrderDetail result = orderDetailRepository.save(orderDetail);
		return result;
	}
	
	//delete OrderDetail
	public void deleteOrderDetail(Long orderDetailId) {
		orderDetailRepository.deleteById(orderDetailId);
	}
	
	//update OrderDetail
	public void updateOrderDetail(OrderDetail orderDetail, Long orderDetailId) {
		orderDetail.setOrderNumber(orderDetailId);
		orderDetailRepository.save(orderDetail);
	}

	//get all OrderDetail sorted by quantity using query
	@Override
	public List<OrderDetail> getOrderDetailSortedByQuantity() {
		List<OrderDetail> list = orderDetailRepository.findAllSortedByQuantity();
		return list;
	}

	//get all OrderDetail sorted by priceEach using native query
	@Override
	public List<OrderDetail> getOrderDetailSortedByPriceEachUsingNative() {
		List<OrderDetail> list = orderDetailRepository.findAllSortedByPriceEachUsingNative();
		return list;
	}

	//get all OrderDetail by matched quantityOrdered
	@Override
	public List<OrderDetail> getAllOrderDetailByQuantityOrdered(int quantityOrdered) {
		List<OrderDetail> list = orderDetailRepository.findByQuantityOrdered(quantityOrdered);
		return list;
	}

	//get all OrderDetail by using paging concept
	@Override
	public List<OrderDetail> getOrderDetailsUsingPaging() {
		Pageable pageable = PageRequest.of(0, 2);
		List<OrderDetail> list = orderDetailRepository.findOrderDetails(pageable);
		return list;
	}

	//get all OrderDetail in a sort order of orderNumber using the concept of Sorting
	@Override
	public Iterable<OrderDetail> getSortOrderDetailsUsingSorting() {
		String sortBy = "orderNumber";
		List<OrderDetail> list = (List<OrderDetail>) orderDetailRepository.sortOrderDetail(Sort.by(Sort.Direction.DESC,sortBy));
		return list;
	}

}
