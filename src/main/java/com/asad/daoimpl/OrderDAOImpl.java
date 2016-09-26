package com.asad.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.asad.dao.OrderDAO;
import com.asad.model.Order;

public class OrderDAOImpl implements OrderDAO {
	@Autowired
	SessionFactory session;

	public boolean saveOrUpdateOrder(Order order) {
		session.getCurrentSession().saveOrUpdate(order);
		return true;
	}

	public boolean deleteOrder(Order order) {
		session.getCurrentSession().delete(order);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Order> getOrders() {
		return session.getCurrentSession().createQuery("from Order").list();
	}

}
