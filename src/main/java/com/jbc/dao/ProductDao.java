package com.jbc.dao;

import com.jbc.model.Product;

public interface ProductDao {

	public int addProduct(Product product);
	public Object getProducutById(long productId);
    public int deleteProductById(Product product);
    public int updateProduct(Product product);
	public Product getMaxProduct();
	
	
	
}
