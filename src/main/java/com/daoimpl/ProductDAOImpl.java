package com.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ProductDAO;
import com.model.Product;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	SessionFactory session;
	
	@SuppressWarnings("unchecked")
	public List<Product> getProducts(){
		return session.getCurrentSession().createQuery("from Product").list();
	}
	
	public boolean saveOrUpdateProduct(Product product){
		session.getCurrentSession().saveOrUpdate(product);
		return true;
	}
	
	public boolean deleteProduct(Product product){
		session.getCurrentSession().delete(product);
		return true;
	}
}
