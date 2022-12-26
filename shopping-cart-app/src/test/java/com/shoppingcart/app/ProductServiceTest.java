package com.shoppingcart.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shoppingcart.app.model.Product;
import com.shoppingcart.app.repository.ProductRepository;
import com.shoppingcart.app.service.ProductService;

@SpringBootTest
public class ProductServiceTest {

	@Autowired
	private ProductService productService;
	
	@MockBean
	private ProductRepository productRepository;
	
	@Test
	public void getAllProductsTest() {
		Product product = new Product();
		
		product.setProductCode(1L);
		product.setProductName("Biscuits");
		product.setProductScale("Sweet and Salty available in all price");
		product.setProductVendor("ApnaApp");
		product.setQuantityInStock(12L);
		product.setBuyPrice(200.08);
		product.setMsrp(250.09);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		assertThat(productService.getAllProducts()).
		isNotNull();	
	}
	
	@Test
	public void getProductByIdTest() {
		Product product = new Product();
		
		product.setProductCode(1L);
		product.setProductName("Happy Happy Biscuit");
		product.setProductScale("Sweet and Salty available in all price");
		product.setProductVendor("ApnaApp");
		product.setQuantityInStock(12L);
		product.setBuyPrice(200.08);
		product.setMsrp(250.09);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		assertThat(productService.getProductById(1L)).
		isNotNull();	
	}

	@Test
	public void addProductTest() {
		Product product = new Product();
		
		product.setProductCode(1L);
		product.setProductName("Happy Happy Biscuit");
		product.setProductScale("Sweet and Salty available in all price");
		product.setProductVendor("ApnaApp");
		product.setQuantityInStock(12L);
		product.setBuyPrice(200.08);
		product.setMsrp(250.09);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		assertThat(productService.addProduct(product)).
		isEqualTo(product);
	}

	@Test
	public void deleteProductTest() {
		Product product = new Product();
		
		product.setProductCode(1L);
		product.setProductName("Happy Happy Biscuit");
		product.setProductScale("Sweet and Salty available in all price");
		product.setProductVendor("ApnaApp");
		product.setQuantityInStock(12L);
		product.setBuyPrice(200.08);
		product.setMsrp(250.09);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		productService.deleteProduct(1L);
		assertThat(productService.getProductById(1L)).
		isEmpty();	
	}
	
	@Test
	public void updateProductTest() {
		Product product = new Product();
		
		product.setProductCode(1L);
		product.setProductName("Happy Happy Biscuit");
		product.setProductScale("Sweet and Salty available in all price");
		product.setProductVendor("ApnaApp");
		product.setQuantityInStock(12L);
		product.setBuyPrice(200.08);
		product.setMsrp(250.09);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		productService.updateProduct(product, 2L);
		assertThat(productService.getProductById(1L)).
		isEmpty();	
	}
	
	@Test
	public void getProductSortedByNameTest() {
		Product product = new Product();
		
		product.setProductCode(1L);
		product.setProductName("Happy Happy Biscuit");
		product.setProductScale("Sweet and Salty available in all price");
		product.setProductVendor("ApnaApp");
		product.setQuantityInStock(12L);
		product.setBuyPrice(200.08);
		product.setMsrp(250.09);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		assertThat(productService.getProductSortedByName()).
		isNotNull();	
	}

	@Test
	public void getProductSortedByMsrpUsingNativeTest() {
		Product product = new Product();
		
		product.setProductCode(1L);
		product.setProductName("Happy Happy Biscuit");
		product.setProductScale("Sweet and Salty available in all price");
		product.setProductVendor("ApnaApp");
		product.setQuantityInStock(12L);
		product.setBuyPrice(200.08);
		product.setMsrp(250.09);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		assertThat(productService.getProductSortedByMsrpUsingNative()).
		isNotNull();	
	}

	@Test
	public void getProductByNameTest() {
		Product product = new Product();
		
		product.setProductCode(1L);
		product.setProductName("Happy Happy Biscuit");
		product.setProductScale("Sweet and Salty available in all price");
		product.setProductVendor("ApnaApp");
		product.setQuantityInStock(12L);
		product.setBuyPrice(200.08);
		product.setMsrp(250.09);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		assertThat(productService.getProductByName("Biscuits")).
		isNotNull();	
	}

	@Test
	public void getProductsUsingPagingTest() {
		Product product = new Product();
		
		product.setProductCode(1L);
		product.setProductName("Happy Happy Biscuit");
		product.setProductScale("Sweet and Salty available in all price");
		product.setProductVendor("ApnaApp");
		product.setQuantityInStock(12L);
		product.setBuyPrice(200.08);
		product.setMsrp(250.09);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		assertThat(productService.getProductsUsingPaging()).
		isNotNull();	
	}
	
	@Test
	public void sortProductsUsingSortingTest() {
		Product product = new Product();
		
		product.setProductCode(1L);
		product.setProductName("Happy Happy Biscuit");
		product.setProductScale("Sweet and Salty available in all price");
		product.setProductVendor("ApnaApp");
		product.setQuantityInStock(12L);
		product.setBuyPrice(200.08);
		product.setMsrp(250.09);
		
		Mockito.when(productRepository.save(product)).
		thenReturn(product);
		assertThat(productService.sortProductsUsingSorting()).
		isNotNull();	
	}

	
}
