package com.asad.dao;

import java.util.List;

import com.asad.model.Order;

public interface OrderDAO {
	public boolean saveOrUpdateOrder(Order order);
	public boolean deleteOrder(Order order);
	public List<Order> getOrders();

}
