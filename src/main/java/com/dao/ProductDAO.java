package com.dao;

import java.util.List;
import com.model.Product;

public interface ProductDAO {
	public List<Product> getProducts();
	public boolean saveOrUpdateProduct(Product product);
	public boolean deleteProduct(Product product);
}
