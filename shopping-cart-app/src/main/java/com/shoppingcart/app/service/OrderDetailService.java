package com.shoppingcart.app.service;

import java.util.List;
import java.util.Optional;

import com.shoppingcart.app.model.OrderDetail;

public interface OrderDetailService {

	public List<OrderDetail> getAllOrderDetails();
	
	public Optional<OrderDetail> getOrderDetailById(Long id);
	
	public OrderDetail addOrderDetail(OrderDetail od);
	
	public void deleteOrderDetail(Long odid);
	
	public void updateOrderDetail(OrderDetail orderDetail, Long orderDetailId);
	
	public List<OrderDetail> getOrderDetailSortedByQuantity();
	
	public List<OrderDetail> getOrderDetailSortedByPriceEachUsingNative();
	
	public List<OrderDetail> getAllOrderDetailByQuantityOrdered(int quantityOrdered);
	
	public List<OrderDetail> getOrderDetailsUsingPaging();
	
	public Iterable<OrderDetail> getSortOrderDetailsUsingSorting();
	
}
