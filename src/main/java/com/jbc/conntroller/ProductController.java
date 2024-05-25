package com.jbc.conntroller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbc.exception.ResourceAlreadyExistsException;
import com.jbc.model.Product;
import com.jbc.service.ProductService;
import com.jbc.service.impl.ProductServiceImpl;

@RestController
public class ProductController {
	
	ProductService service=new ProductServiceImpl();
	
	@PostMapping("/add-product")
	public String addProduct(@RequestBody @Valid Product product)
	{
		System.out.println(product);
		int status= service.addProduct(product);
		if (status==1) {
			return "added succcefully";
		}else if (status==2) {
			 throw new ResourceAlreadyExistsException("already exits resource Id" + product.getProductId());
			
		}else {
			return "somthing went wrong";
		}
      
		
		
    }
	
	@GetMapping("/Delete-product-by-id")
	public String deletProduct(@RequestParam("productId")long productId) 
	{
		int status = service.deleteProductById(productId);
		switch (status) {
		case 1:
			return "Deleted Successfully !"+ productId;
		case 2:
			return "product not found" + productId;
		case 3:
			return "something went wrong during delete product ,Id = " + productId;
		case 4:
			return "something went wrong during delete product ,Id = " + productId;	
		
		}
		return null;
	}
	@PutMapping("/Update-Product")
	public String updateProduct(@RequestBody Product product , @RequestParam("productId")long productId) 
	{
		int status = service.updateProduct(product);
		switch (status) {
		
		
		case 1:
			return "Update Successfully !"+ product.getProductId() ;
		case 2:
			return "product not found" + product.getProductId();
		case 3:
			return "something went wrong during update product ,Id = " + product.getProductId();
		case 4:
			return "something went wrong during update product ,Id = " + product.getProductId();	
		
		}
		return null;
	}
	@GetMapping("/Get-Max-Product")
	public Object getMaxProduct( ) {
		Product maxProduct = service.getMaxProduct();
		if (maxProduct==null) {
			return"max price could not be found";
		}
		else {
			return maxProduct;
		}
		
	}

	
	
	
}