package com.jbc.service.impl;

import com.jbc.dao.ProductDao;
import com.jbc.dao.impl.ProductDaoImpl;
import com.jbc.model.Product;
import com.jbc.service.ProductService;

public class ProductServiceImpl implements ProductService {

	ProductDao dao=new ProductDaoImpl();
	@Override
	public int addProduct(Product product) {
		int product2 = dao.addProduct(product);
		
		
		
		
		return product2;
	}
	@Override
	public int deleteProductById(long productId) {
		// TODO Auto-generated method stub
		//1.deleted
		//2.not exists
		//3.somthing went wrong
		//4.somthing went wrong
		int status=0;
		Object object = dao.getProducutById(productId);
		if(object instanceof Product) {
			status = dao.deleteProductById((Product)object);
		}else if (object instanceof String) {
			String msg= (String)object;
			if ("something went wrong".equals(msg)) {
			status= 4;
			} else {
				status = 2;
             }
		}
		
		
		
		return status;
	}
	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		int status=0;
		Object object = dao.getProducutById(product.getProductId());
		if(object instanceof Product) {
			status = dao.deleteProductById((Product)object);
		}else if (object instanceof String) {
			String msg= (String)object;
			if ("something went wrong".equals(msg)) {
			status= 4;
			} else {
				status = 2;
             }
		}
		
		
		
		return status;
		
		
	}
	@Override
	public  Product getMaxProduct() {
		return dao.getMaxProduct();
	}

}
