package com.shoppingcart.app.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shoppingcart.app.controller.ProductLineController;
import com.shoppingcart.app.exception.ProductLineNotFoundException;
import com.shoppingcart.app.model.ProductLine;

@Controller
public class ProductLineMain {
	
	@Autowired
	private ProductLineController productLineController;
	
	public void productLineRun() throws NumberFormatException, IOException {
		System.out.println("\n ProductLine Entity records :");
		addProductLines(createProductLines());
	}

	//method to add ProductLine
	private void addProductLines(List<ProductLine> productLines) {
		for(ProductLine productLine : productLines) {
			try {
				productLineController.addProductLine(productLine);
			} 
			catch (ProductLineNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//method to create List of ProductLine
	private List<ProductLine> createProductLines(){
		List<ProductLine> productLines = new ArrayList<ProductLine>();
		
		ProductLine pl1 = new ProductLine("The world famous co-operative dairy ‘Amul’ is"
				+ " one of the main features of Anand. Amul is the biggest dairy not"
				+ " only in India, but in Asia too.",
				"<ol>"
				+ "<li>Amul offers a plethora of product lines that are closely related"
				+ " but still different.</li>"
				+ "</ol>","ANUD.jpg",null);
		
		ProductLine pl2 = new ProductLine("Gucci is an Italian fashion brand founded in"
				+ " 1921 by Guccio Gucci, making it one of the oldest Italian fashion"
				+ " brands in operation today. ",
				"<ol>"
				+ "<li>Their products are usually bespoke leather accessories, from"
				+ " handbags to shoes.</li>"
				+ "</ol>","GUCCI.jpg",null);
		
		ProductLine pl3 = new ProductLine("Dell is an American technology company that"
				+ " develops, sells, repairs, and supports computers and related"
				+ " products and services and is owned by its parent company.",
				"<ol>"
				+"<li>Dell is a provider of desktop personal computers, software, and "
				+ "peripherals.</li>"
				+"</ol>", "DELL.jpg", null);
		
		ProductLine pl4 = new ProductLine("Puma SE (Puma) is a sporting goods and"
				+ " equipment manufacturer that designs, develops, and markets"
				+ " footwear, apparel, and accessories for men, women, and children.",
				"<ol>"
				+ "<li> The company markets products under PUMA, stitched, and Cobra"
				+ " Golf brand names.</li>"
				+"</ol>","PUMA.jpg", null);
	
		productLines.add(pl1);
		productLines.add(pl2);
		productLines.add(pl3);
		productLines.add(pl4);
		
		return productLines;
	}
}
