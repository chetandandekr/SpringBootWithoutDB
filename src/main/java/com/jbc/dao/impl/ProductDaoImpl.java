package com.jbc.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.jbc.dao.ProductDao;
import com.jbc.model.Product;

public class ProductDaoImpl implements ProductDao {

	List<Product> list=new ArrayList<>();// in our case list = is db.

	
	public int addProduct(Product product) {
		if (list.equals(product)) {
			return 2;
		}else {
			list.add(product);
			return 1;
		}
		
	}


	@Override
	public int deleteProductById(Product product) {
		int status =0;
		try {
			
			list.remove(product);
			status = 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			status = 3;
		}
		return status;
	}

	@Override
	public Object getProducutById(long productId) {
		// TODO Auto-generated method stub
		try {
			for (Product product : list) {
				if (product.getProductId() == productId) {
					return product;
				}
				
			}
		} catch ( Exception e) {
			e.printStackTrace();
			return "something went wrong";
			// TODO: handle exception
		}
		return "product not found ";
	}


	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		int status =0;
		try {
			Object dbproduct = getProducutById(product.getProductId());
			int index = list.indexOf(dbproduct);
			
			list.set(index, product);
			status = 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); ;
		}
		return status;
		}
	
	public ProductDaoImpl() {
		list.add(new Product (101,"aa",1,1,1000,10,10));
		list.add(new Product(102,"bb",1,1,100,5,10));
		list.add(new Product(103,"cc",1,1,1500,15,15));
		list.add(new Product(103,"dd",1,1,20000,12,13));
	}

	
	@Override
	public Product getMaxProduct() {
		Product max =null;
		try {
			  max = Collections.max(list,Comparator.comparing(Product->Product.getProductPrice()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(max);
		return max;
		
	}

}
