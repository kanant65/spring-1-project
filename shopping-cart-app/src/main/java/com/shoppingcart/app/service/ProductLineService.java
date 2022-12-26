package com.shoppingcart.app.service;

import java.util.List;
import java.util.Optional;

import com.shoppingcart.app.model.ProductLine;

public interface ProductLineService {

	public List<ProductLine> getAllProductlines();
	
	public Optional<ProductLine> getProductLineById(Long id);
	
	public ProductLine addProductLine(ProductLine productLine);
	
	public void deleteProductLine(Long pid);
	
	public void updateProductLine(ProductLine productLine, Long ProductLineId);
	
	public List<ProductLine> getProductLineDetailSortedByText();
	
	public List<ProductLine> getProductLineSortedByHtmlTextUsingNative();
	
	public ProductLine getProductLineByImageSrc(String image);
	
	public List<ProductLine> getProductLinesUsingPaging();
	
	public Iterable<ProductLine> getSortProductLinesUsingSorting();
	
}
