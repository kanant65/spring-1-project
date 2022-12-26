package com.shoppingcart.app.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.model.ProductLine;
import com.shoppingcart.app.repository.ProductLineRepository;
import com.shoppingcart.app.service.ProductLineService;

@Service
public class ProductLineServiceImpl implements ProductLineService {

	@Autowired
	private ProductLineRepository productLineRepository;
	
	//get all ProductLines
	public List<ProductLine> getAllProductlines(){
		List<ProductLine> list = productLineRepository.findAll();
		return list;
	}
	
	//get single ProductLine by id
	public Optional<ProductLine> getProductLineById(Long id) {
		Optional<ProductLine> productLine = productLineRepository.findById(id);
		return productLine;
	}
	
	//adding the ProductLine
	public ProductLine addProductLine(ProductLine p) {
		ProductLine result = productLineRepository.save(p);
		return result;
	}
	
	//delete ProductLine
	public void deleteProductLine(Long pid) {
		productLineRepository.deleteById(pid);
	}
	
	//update ProductLine
	public void updateProductLine(ProductLine productLine, Long ProductLineId) {
		productLine.setProductLine(ProductLineId);
		productLineRepository.save(productLine);
	}

	//get all ProductLines in a sorted order of text by using query
	@Override
	public List<ProductLine> getProductLineDetailSortedByText() {
		List<ProductLine> list = productLineRepository.findAllSortedByText();
		return list;
	}

	//get all ProductLines in a sorted order of HTML text using native query
	@Override
	public List<ProductLine> getProductLineSortedByHtmlTextUsingNative() {
		List<ProductLine> list = productLineRepository.findAllSortedByHtmlTextUsingNative();
		return list;
	}

	//get single ProductLine by matched image 
	@Override
	public ProductLine getProductLineByImageSrc(String image) {
		ProductLine productLine = productLineRepository.findByImage(image);
		return productLine;
	}

	//get all ProductLines by using paging concept
	@Override
	public List<ProductLine> getProductLinesUsingPaging() {
		Pageable pageable = PageRequest.of(0, 2);
		List<ProductLine> list = productLineRepository.findProductlines(pageable);
		return list;
	}

	//get all ProductLines in a sorted order of textDescription using the concept of Sorting
	@Override
	public Iterable<ProductLine> getSortProductLinesUsingSorting() {
		String sortBy = "image";
		List<ProductLine> list = (List<ProductLine>) productLineRepository.sortProductLine(Sort.by(Sort.Direction.ASC,sortBy));
		return list;
	}

}
