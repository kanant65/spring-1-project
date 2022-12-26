package com.shoppingcart.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.app.exception.ProductNotFoundException;
import com.shoppingcart.app.model.Product;
import com.shoppingcart.app.service.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//get all Product handler
	@GetMapping("products")
	public ResponseEntity<List<Product>> getAllProducts() throws ProductNotFoundException {
		List<Product> product = productService.getAllProducts();
		
		if(product.size()<=0) {
			throw new ProductNotFoundException("Product not exist");
		}
		return ResponseEntity.of(Optional.of(product));
	}

	//get single Product handler
	@GetMapping("products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) throws ProductNotFoundException  {
		Product product = productService.getProductById(id)
				 .orElseThrow(() -> new ProductNotFoundException("Product not exist with id:" + id));
		
		if(product == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(product));
	}
	
	//new ProductLine handler
	@PostMapping("products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws ProductNotFoundException {
		Product p = productService.addProduct(product);
		
		if(p == null) {
			throw new ProductNotFoundException("Product not get inserted");
		}
		return ResponseEntity.of(Optional.of(p));
	}
		
	//delete ProductLine handler
	@DeleteMapping("products/{productId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long productId) throws ProductNotFoundException {
		
		productService.getProductById(productId)
			.orElseThrow(() -> new ProductNotFoundException("Product not exist with id:" + productId));
		
		productService.deleteProduct(productId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	//update Product handler
	@PutMapping("products/{productId}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("productId") Long productId) throws ProductNotFoundException {
		
		productService.getProductById(productId)
			 .orElseThrow(() -> new ProductNotFoundException("Product not exist with id:" + productId));
		
		productService.updateProduct(product, productId);
		return ResponseEntity.ok(product);
		
	}

	//get all Product handler sorted by name using query
	@GetMapping("products/sort")
	public ResponseEntity<List<Product>> getProductSortedByName() throws ProductNotFoundException {
		List<Product> product = productService.getProductSortedByName();
		
		if(product.size()<=0) {
			throw new ProductNotFoundException("Product not exist");
		}
		return ResponseEntity.of(Optional.of(product));
	}
	
	//get all Product handler sorted by MSRP using native query
	@GetMapping("products/sort/native")
	public ResponseEntity<List<Product>> getProductSortedByMsrpUsingNative() throws ProductNotFoundException {
		List<Product> product = productService.getProductSortedByMsrpUsingNative();
		
		if(product.size()<=0) {
			throw new ProductNotFoundException("Product not exists ");
		}
		return ResponseEntity.of(Optional.of(product));
	}
	
	//get Product handler by product name 
	@GetMapping("products/name/{productName}")
	public ResponseEntity<List<Product>> getProductByName(@PathVariable("productName") String productName) throws ProductNotFoundException{
		List<Product> product = productService.getProductByName(productName);
		
		if(product == null) {
			throw new ProductNotFoundException("Product not exists with productName : " + productName);
		}
		return ResponseEntity.of(Optional.of(product));
	}
	
	//paging implementation
	@GetMapping("products/paging")
	public ResponseEntity<List<Product>> getProducts() throws ProductNotFoundException {
		List<Product> product = productService.getProductsUsingPaging();
		
		if(product.size()<=0) {
			throw new ProductNotFoundException("Product not exist");
		}
		return ResponseEntity.of(Optional.of(product));
	}

	//sorting implementation
	@GetMapping("products/sorting")
	public ResponseEntity<Iterable<Product>> getSortProducts() throws ProductNotFoundException {
		List<Product> product = (List<Product>) productService.sortProductsUsingSorting();
		
		if(product.size()<=0) {
			throw new ProductNotFoundException("Product not exist");
		}
		return ResponseEntity.of(Optional.of(product));
	}
	
}
