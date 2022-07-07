package com.sharedpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sharedpro.model.Product;
import com.sharedpro.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//create
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
		
	}
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products){
		return productService.saveProducts(products);
	}
	
	
	//read
	
	@GetMapping("/products")
	public List<Product> findAllProducts(){
		return productService.getProducts();
	}
	
	@GetMapping("/product/{id}")
	public Product findProductById(@PathVariable int  id) {
		return productService.getProductById(id);
	}
	
	@GetMapping("/products/{name}")
	public Product findProductByName(@PathVariable String name) {
		return productService.getProductByName(name);
	}
	
	// update
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return productService.deleteById(id);
	}
}
