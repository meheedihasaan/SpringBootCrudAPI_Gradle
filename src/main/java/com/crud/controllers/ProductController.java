package com.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entites.Product;
import com.crud.services.ProductServices;

@RestController
public class ProductController {
	
	@Autowired
	private ProductServices productService;

	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> product){
		return productService.saveProducts(product);
	}
	
	@GetMapping("/product/all")
	public List<Product> getProducts(){
		return productService.getProducts();
	}
	
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable int id) {
		return productService.getProductById(id);
	}
	
	@PutMapping("product/update")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("product/delete/{id}")
	public void deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
	}
	
}
