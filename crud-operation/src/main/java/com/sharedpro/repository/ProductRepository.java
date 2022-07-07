package com.sharedpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sharedpro.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByName(String name);
	

}
