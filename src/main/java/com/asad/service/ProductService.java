package com.asad.service;

import java.util.List;

import com.asad.model.Product;

public interface ProductService {
	public List<Product> getProducts();
	public boolean saveOrUpdateProduct(Product product);
	public boolean deleteProduct(Product product);
}
