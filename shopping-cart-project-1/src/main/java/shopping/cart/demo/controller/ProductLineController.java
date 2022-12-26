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
import org.springframework.web.bind.annotation.RestController;

import shopping.cart.demo.exception.PaymentNotFoundException;
import shopping.cart.demo.exception.ProductLineNotFoundException;
import shopping.cart.demo.model.Payment;
import shopping.cart.demo.model.ProductLine;
import shopping.cart.demo.repository.ProductLineRepository;

@RestController
@RequestMapping("/api/v1/")
public class ProductLineController {

	@Autowired
	private ProductLineRepository productLineRepository;
	

	//get all ProductLine handler
	@GetMapping("/productlines")
	public ResponseEntity<List<ProductLine>> getProductLines() throws ProductLineNotFoundException {
		List<ProductLine> list = productLineRepository.findAll();
		
		if(list.size()<=0) {
			throw new ProductLineNotFoundException("ProductLine not exist");
		}
		return ResponseEntity.of(Optional.of(list));
	}

	//get single ProductLine handler
	@GetMapping("/productlines/{id}")
	public ResponseEntity<ProductLine> getProductLine(@PathVariable("id") Long id) throws ProductLineNotFoundException  {
		ProductLine productLine = productLineRepository.findById(id)
				 .orElseThrow(() -> new ProductLineNotFoundException("ProductLine not exist with id:" + id));
		
		if(productLine == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(productLine));
	}
	
	//new ProductLine handler
	@PostMapping("/productlines")
	public ResponseEntity<ProductLine> addProductLine(@RequestBody ProductLine productLine) throws ProductLineNotFoundException {
		ProductLine p = productLineRepository.save(productLine);
		
		if(productLineRepository.save(productLine) == null) {
			throw new ProductLineNotFoundException("ProductLine not get inserted");
		}
		return ResponseEntity.of(Optional.of(p));
	}
		
	
	//delete ProductLine handler
	@DeleteMapping("/productlines/{productLineId}")
	public ResponseEntity<Void> deleteProductLine(@PathVariable("productLineId") Long productLineId) throws ProductLineNotFoundException {
		
		ProductLine productLine = productLineRepository.findById(productLineId)
				 .orElseThrow(() -> new ProductLineNotFoundException("ProductLine not exist with id:" + productLineId));
		
		productLineRepository.delete(productLine);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	//update ProductLine handler
	@PutMapping("/productlines/{productLineId}")
	public ResponseEntity<ProductLine> updateProductLine(@RequestBody ProductLine productLine, @PathVariable("productLineId") Long productLineId) throws ProductLineNotFoundException {
		
		ProductLine updateProductLine = productLineRepository.findById(productLineId)
				 .orElseThrow(() -> new ProductLineNotFoundException("ProductLine not exist with id:" + productLineId));
		
		updateProductLine.setProductLine(productLineId);
		productLineRepository.save(productLine);
		
		return ResponseEntity.ok(productLine);
		
	}

	//get all ProductLine handler sorted by text
	@GetMapping("productlines/sort")
	public ResponseEntity<List<ProductLine>> getProductLineDetailSortedByText() throws ProductLineNotFoundException {
		List<ProductLine> list = productLineRepository.findAllSortedByText();
			
		if(list.size()<=0) {
			throw new ProductLineNotFoundException("ProductLine not exists ");
		}
		return ResponseEntity.of(Optional.of(list));
	}
		
	//get all ProductLine handler sorted by text
	@GetMapping("productlines/sort/native")
	public ResponseEntity<List<ProductLine>> getProductLineSortedByTextUsingNative() throws ProductLineNotFoundException {
		List<ProductLine> list = productLineRepository.findAllSortedByTextUsingNative();
			
		if(list.size()<=0) {
			throw new ProductLineNotFoundException("ProductLine not exists ");
		}
		return ResponseEntity.of(Optional.of(list));
	}	
}
