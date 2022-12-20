package com.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entites.Product;
import com.crud.repositories.ProductRepository;

@Service
public class ProductServices {

	@Autowired
	private ProductRepository productRepo;
	
		//To save a single product
		public Product saveProduct(Product product) {
			return productRepo.save(product);
		}
		
		//To save multiple products
		public List<Product> saveProducts(List<Product> products){
			return (List<Product>) productRepo.saveAll(products);
		}
		
		//To get all the products
		public List<Product> getProducts(){
			return (List<Product>) productRepo.findAll();
		}
		
		//To get a single product by it's id
		public Product getProductById(int id) {
			Optional<Product> product = productRepo.findById(id);
			if(product.isPresent()) {
				return product.get();
			}
			else {
				return null;
			}
			//return productRepo.findById(id).orElse(null);
		}
		
		//To update an existing product
		public Product updateProduct(Product product) {
			//Finding existing product
			Product existingProduct = productRepo.findById(product.getId()).orElse(null);
			
			//Updating existing product
			existingProduct.setId(product.getId());
			existingProduct.setName(product.getName());
			existingProduct.setQuantity(product.getQuantity());
			existingProduct.setPrice(product.getPrice());
			
			return productRepo.save(existingProduct);
		}
		
		//To delete a product by it's id
		public void deleteProduct(int id) {
			productRepo.deleteById(id);
			System.out.println(id+" is deleted.");
		}
		
	
}
