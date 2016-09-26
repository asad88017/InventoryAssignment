package com.asad.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asad.dao.OrderDAO;
import com.asad.model.Order;
import com.asad.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDAO orderDAO;

	public boolean saveOrUpdateOrder(Order order) {
		return orderDAO.saveOrUpdateOrder(order);
	}

	public boolean deleteOrder(Order order) {
		return orderDAO.deleteOrder(order);
	}

	public List<Order> getOrders() {
		return orderDAO.getOrders();
	}

}
