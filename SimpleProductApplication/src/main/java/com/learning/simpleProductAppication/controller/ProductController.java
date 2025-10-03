package com.learning.simpleProductAppication.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.grammars.hql.HqlParser.IndexKeyQuantifierContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.simpleProductAppication.model.Product;
import com.learning.simpleProductAppication.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/Products")
	public ResponseEntity<List<Product>> getAllproducts() {
		return new ResponseEntity<>(service.getProducts(), HttpStatus.OK); 
		//return service.getProducts();
	}
	
	@GetMapping("/Products/{prodId}")
	public ResponseEntity<Product> getProductById(@PathVariable int prodId) {
		Product product = service.getProductwithId(prodId);
		if(product != null)
			return new ResponseEntity<>(product, HttpStatus.OK);
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		//return service.getProductwithId(prodId);
	}
	
	@PostMapping("/Products")
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		service.addProduct(product);
		return new ResponseEntity<>("Added Product", HttpStatus.OK);
	}
	
	@PutMapping("/Products")
	public ResponseEntity<String> updateProduct(@RequestBody Product product) {
		Product product2 = service.updateProduct(product);
		if(product2 != null)
			return new ResponseEntity<>("Product details Updated", HttpStatus.OK);
		else
			return new ResponseEntity<>("Product NOT Updated", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/Products/{prodId}")
	public void deleteProduct(@RequestBody int prodId) {
		service.deleteProduct(prodId);
	}
	
	@GetMapping("/Products/search")
	public ResponseEntity<List<Product>> searchProduct(@RequestParam String keyword){
		System.out.println("Keyword"+keyword);
		List<Product> products = service.searchProducts(keyword);
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
}
