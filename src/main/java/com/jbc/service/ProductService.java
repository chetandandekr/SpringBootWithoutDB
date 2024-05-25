package com.jbc.service;

import com.jbc.model.Product;

public interface ProductService {
	
	public int addProduct(Product product);
	public int deleteProductById(long productId);
	public int updateProduct(Product product);
	public Product getMaxProduct();

}
