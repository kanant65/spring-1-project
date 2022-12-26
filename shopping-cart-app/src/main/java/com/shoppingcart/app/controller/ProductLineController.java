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

import com.shoppingcart.app.exception.ProductLineNotFoundException;
import com.shoppingcart.app.model.ProductLine;
import com.shoppingcart.app.service.ProductLineService;

@RestController
@RequestMapping("/api/v1/")
public class ProductLineController {

	@Autowired
	private ProductLineService productLineService;
	
	//get all ProductLine handler
	@GetMapping("productlines")
	public ResponseEntity<List<ProductLine>> getAllProductLines() throws ProductLineNotFoundException {
		List<ProductLine> productLine = productLineService.getAllProductlines();
		
		if(productLine.size()<=0) {
			throw new ProductLineNotFoundException("ProductLine not exist");
		}
		return ResponseEntity.of(Optional.of(productLine));
	}

	//get single ProductLine handler
	@GetMapping("productlines/{id}")
	public ResponseEntity<ProductLine> getProductLine(@PathVariable("id") Long id) throws ProductLineNotFoundException  {
		ProductLine productLine = productLineService.getProductLineById(id)
				 .orElseThrow(() -> new ProductLineNotFoundException("ProductLine not exist with id:" + id));
		
		if(productLine == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(productLine));
	}
	
	//new ProductLine handler
	@PostMapping("productlines")
	public ResponseEntity<ProductLine> addProductLine(@RequestBody ProductLine productLine) throws ProductLineNotFoundException {
		ProductLine p = productLineService.addProductLine(productLine);
		
		if(p == null) {
			throw new ProductLineNotFoundException("ProductLine not get inserted");
		}
		return ResponseEntity.of(Optional.of(p));
	}
		
	
	//delete ProductLine handler
	@DeleteMapping("productlines/{productLineId}")
	public ResponseEntity<Void> deleteProductLine(@PathVariable("productLineId") Long productLineId) throws ProductLineNotFoundException {
		
		productLineService.getProductLineById(productLineId)
			.orElseThrow(() -> new ProductLineNotFoundException("ProductLine not exist with id:" + productLineId));
		
		productLineService.deleteProductLine(productLineId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	//update ProductLine handler
	@PutMapping("productlines/{productLineId}")
	public ResponseEntity<ProductLine> updateProductLine(@RequestBody ProductLine productLine, @PathVariable("productLineId") Long productLineId) throws ProductLineNotFoundException {
		
		productLineService.getProductLineById(productLineId)
			.orElseThrow(() -> new ProductLineNotFoundException("ProductLine not exist with id:" + productLineId));
		
		productLineService.updateProductLine(productLine, productLineId);
		
		return ResponseEntity.ok().body(productLine);
		
	}

	//get all ProductLine handler sorted by text using query
	@GetMapping("productlines/sort")
	public ResponseEntity<List<ProductLine>> getProductLineDetailSortedByText() throws ProductLineNotFoundException {
		List<ProductLine> productLine = productLineService.getProductLineDetailSortedByText();
			
		if(productLine.size()<=0) {
			throw new ProductLineNotFoundException("ProductLine not exists ");
		}
		return ResponseEntity.of(Optional.of(productLine));
	}
		
	//get all ProductLine handler sorted by HTML text using native query
	@GetMapping("productlines/sort/native")
	public ResponseEntity<List<ProductLine>> getProductLineSortedByHtmlTextUsingNative() throws ProductLineNotFoundException {
		List<ProductLine> productLine = productLineService.getProductLineSortedByHtmlTextUsingNative();
			
		if(productLine.size()<=0) {
			throw new ProductLineNotFoundException("ProductLine not exists ");
		}
		return ResponseEntity.of(Optional.of(productLine));
	}	
	
	//get ProductLine handler by image
	@GetMapping("productlines/images/{image}")
	public ResponseEntity<ProductLine> getProductLineByImageSrc(@PathVariable("image") String image) throws ProductLineNotFoundException {
		ProductLine productLine = productLineService.getProductLineByImageSrc(image);
		
		if(productLine == null) {
			throw new ProductLineNotFoundException("ProductLine not exists with image = " + image);
		}
		return ResponseEntity.of(Optional.of(productLine));
	}

	//implementing paging
	@GetMapping("productlines/paging")
	public ResponseEntity<List<ProductLine>> getProductLines() throws ProductLineNotFoundException{
		List<ProductLine> productLine = productLineService.getProductLinesUsingPaging();
		
		if(productLine.size()<=0) {
			throw new ProductLineNotFoundException("ProductLine not exist");
		}
		return ResponseEntity.of(Optional.of(productLine));
	}

	//sorting implementation
	@GetMapping("productlines/sorting")
	public ResponseEntity<Iterable<ProductLine>> getSortProductLines() throws ProductLineNotFoundException {
		List<ProductLine> productLine = (List<ProductLine>) productLineService.getSortProductLinesUsingSorting();
		
		if(productLine.size()<=0) {
			throw new ProductLineNotFoundException("ProductLine not exist");
		}
		return ResponseEntity.of(Optional.of(productLine));
	}
	
}
