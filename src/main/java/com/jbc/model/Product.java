package com.jbc.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Product {
    //@NotNull @NotEmpty @Min (value = 1)
	private long productId;
	@NotBlank (message = "Product not be be blank")
	private String productName;
	@Min(value = 1)
	private long supplierID;
	
	@Min(value = 1)
	
	private long categoryId;
	
	@Min(value = 1)
	private int productQty;
	
	@Min(value = 0)
	private double productPrice;
	
	@Min(value = 0)
	private int deliveryCharges;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(long productId, String productName, long supplierID, long categoryId, int productQty,
			double productPrice, int deliveryCharges) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.supplierID = supplierID;
		this.categoryId = categoryId;
		this.productQty = productQty;
		this.productPrice = productPrice;
		this.deliveryCharges = deliveryCharges;
	}


	public long getProductId() {
		return productId;
	}


	public void setProductId(long productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public long getSupplierID() {
		return supplierID;
	}


	public void setSupplierID(long supplierID) {
		this.supplierID = supplierID;
	}


	public long getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}


	public int getProductQty() {
		return productQty;
	}


	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	public int getDeliveryCharges() {
		return deliveryCharges;
	}


	public void setDeliveryCharges(int deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", supplierID=" + supplierID
				+ ", categoryId=" + categoryId + ", productQty=" + productQty + ", productPrice=" + productPrice
				+ ", deliveryCharges=" + deliveryCharges + "]";
	}
	
	
	
}
