package com.learning.simpleProductAppication.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.simpleProductAppication.model.Product;
import com.learning.simpleProductAppication.repository.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo productRepo;
	
	List<Product> products = new ArrayList<>(Arrays.asList(
			new Product(101,"Iphone",50000),
			new Product(102,"Samsung",60000),
			new Product(103,"Sony",40000)));

	//products.add(new Product(101,"Iphone",50000));
	
	public List<Product> getProducts() {
		//return products;	
		return productRepo.findAll();
	}

	public Product getProductwithId(int prodId) {
//		return products.stream()
//				.filter(p -> p.getProdId() == prodId)
//				.findFirst().orElse(new Product(100, "Not Found", 0));
		return productRepo.findById(prodId).orElse(null);
	}
	
	public void addProduct(Product product) {
		//products.add(product);
		productRepo.save(product);
	}

	public Product updateProduct(Product product) {
//		products.stream().map(p -> p.getProdId() == product.getProdId() ? new Product(product.getProdId(), product.getProdName(), product.getProdPrice()) : products)
//		.collect(Collectors.toList());
		return productRepo.save(product);
	}

	public void deleteProduct(int prodId) {
		Product prod = productRepo.findById(prodId).get();
		if(prod !=null) {
			productRepo.deleteById(prodId);
		}
	}

	public List<Product> searchProducts(String keyword) {
		return productRepo.findByKeyword(keyword);
	}
	
}
