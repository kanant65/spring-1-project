package com.shoppingcart.app.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.model.Product;
import com.shoppingcart.app.repository.ProductRepository;
import com.shoppingcart.app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	//get all Products
	public List<Product> getAllProducts(){
		List<Product> list = (List<Product>)this.productRepository.findAll();
		return list;
	}
	
	//get single Product by id
	public Optional<Product> getProductById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		return product;
	}
	
	//adding the Product
	public Product addProduct(Product p) {
		Product result = productRepository.save(p);
		return result;
	}
	
	//delete Product
	public void deleteProduct(Long pid) {
		productRepository.deleteById(pid);
	}
	
	//update Product
	public void updateProduct(Product product, Long ProductId) {
		product.setProductCode(ProductId);
		productRepository.save(product);
	}
	
	//get all Products sorted by name using query 
	@Override
	public List<Product> getProductSortedByName() {
		List<Product> list = productRepository.findAllSortedByName();
		return list;
	}

	//get all Products sorted by MSRP using native query
	@Override
	public List<Product> getProductSortedByMsrpUsingNative() {
		List<Product> list = productRepository.findAllSortedByMsrpUsingNative();
		return list;
	}

	//get all Products matched by productName 
	@Override
	public List<Product> getProductByName(String productName) {
		List<Product> list = productRepository.findByProductName(productName);
		return list;
	}

	//get all Products using paging concept
	@Override
	public List<Product> getProductsUsingPaging() {
		Pageable pageable = PageRequest.of(0, 2);
		List<Product> list = productRepository.findProducts(pageable);
		return list;
	}

	//get all Products in a sort order of quantityInStock using the concept Sorting
	@Override
	public Iterable<Product> sortProductsUsingSorting() {
		String sortBy = "productVendor";
		List<Product> list = (List<Product>) productRepository.sortProduct(Sort.by(Sort.Direction.DESC,sortBy));
		return list;
	}

	
}
