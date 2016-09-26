package com.asad.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asad.dao.ProductDAO;
import com.asad.model.Product;
import com.asad.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDAO productDAO;
	

	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productDAO.getProducts();
	}

	public boolean saveOrUpdateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDAO.saveOrUpdateProduct(product);
	}

	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		return productDAO.deleteProduct(product);
	}

}
