package com.asad.dao;

import java.util.List;

import com.asad.model.Product;

public interface ProductDAO {
	public List<Product> getProducts();
	public boolean saveOrUpdateProduct(Product product);
	public boolean deleteProduct(Product product);
}
