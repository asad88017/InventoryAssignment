package com.asad.service;

import java.util.List;

import com.asad.model.Order;

public interface OrderService {
	public boolean saveOrUpdateOrder(Order order);
	public boolean deleteOrder(Order order);
	public List<Order> getOrders();

}
