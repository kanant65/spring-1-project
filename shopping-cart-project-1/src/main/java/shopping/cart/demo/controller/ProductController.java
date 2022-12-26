package shopping.cart.demo.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shopping.cart.demo.exception.ProductNotFoundException;
import shopping.cart.demo.model.Product;
import shopping.cart.demo.repository.ProductRepository;

@RestController
@RequestMapping("/api/v1/")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	//get all Product handler
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() throws ProductNotFoundException {
		List<Product> list = productRepository.findAll();
		
		if(list.size()<=0) {
			throw new ProductNotFoundException("Product not exist");
		}
		return ResponseEntity.of(Optional.of(list));
	}

	//get single Product handler
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) throws ProductNotFoundException  {
		Product product = productRepository.findById(id)
				 .orElseThrow(() -> new ProductNotFoundException("Product not exist with id:" + id));
		
		if(product == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(product));
	}
	
	//new ProductLine handler
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws ProductNotFoundException {
		Product p = productRepository.save(product);
		
		if(productRepository.save(product) == null) {
			throw new ProductNotFoundException("Product not get inserted");
		}
		return ResponseEntity.of(Optional.of(p));
	}
		
	//delete ProductLine handler
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long productId) throws ProductNotFoundException {
		
		Product product = productRepository.findById(productId)
				 .orElseThrow(() -> new ProductNotFoundException("Product not exist with id:" + productId));
		
		productRepository.delete(product);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	//update Product handler
	@PutMapping("/products/{productId}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("productId") Long productId) throws ProductNotFoundException {
		
		Product updateProduct = productRepository.findById(productId)
				 .orElseThrow(() -> new ProductNotFoundException("Product not exist with id:" + productId));
		
		updateProduct.setProductCode(productId);
		productRepository.save(product);
		
		return ResponseEntity.ok(updateProduct);
		
	}

	//get all Product handler sorted by name
	@GetMapping("/products/sort")
	public ResponseEntity<List<Product>> getProductSortedByName() throws ProductNotFoundException {
		List<Product> list = productRepository.findAllSortedByName();
		
		if(list.size()<=0) {
			throw new ProductNotFoundException("Product not exist");
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	//get all Product handler sorted by name using native
	@GetMapping("products/sort/native")
	public ResponseEntity<List<Product>> getProductSortedByNameUsingNative() throws ProductNotFoundException {
		List<Product> list = productRepository.findAllSortedByNameUsingNative();
		
		if(list.size()<=0) {
			throw new ProductNotFoundException("Product not exists ");
		}
		return ResponseEntity.of(Optional.of(list));
	}
	

	//get single Product handler by product name 
	@GetMapping("products/productName")
	public ResponseEntity<Product> getProductByName(@RequestParam String productName) throws ProductNotFoundException{
		Product product = productRepository.findByProductName(productName);
		
		if(product == null) {
			throw new ProductNotFoundException("Product not exists with productName : " + productName);
		}
		return ResponseEntity.of(Optional.of(product));
	}
}
