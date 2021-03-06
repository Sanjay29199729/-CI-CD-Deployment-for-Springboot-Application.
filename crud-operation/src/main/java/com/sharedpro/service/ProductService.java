package com.sharedpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharedpro.model.Product;
import com.sharedpro.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	// for creating product
	public Product saveProduct(Product product) {
		return productRepository.save(product);

	}

	
	public List<Product> saveProducts(List<Product> products) {
		return productRepository.saveAll(products);
	}

	// for reading operation
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

    public Product getProductById(int id) 
    {
    	return productRepository.findById(id).orElse(null);
    }
    public Product getProductByName(String name) {
    	return productRepository.findByName(name);	
    }
    
   // for delete operation
    
    public String deleteById(int id) {
    	productRepository.deleteById(id);
    	return "product removed "+id;
    }
    
    
    // for update operation
    public Product updateProduct(Product product) {
    	Product existingProduct = productRepository.findById(product.getId()).orElse(null);
    	existingProduct.setName(product.getName());
    	existingProduct.setPrice(product.getPrice());
    	existingProduct.setPrice(product.getPrice());
    	return productRepository.save(existingProduct);
    	
    }
}
