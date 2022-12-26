package com.project.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.Category;
import com.project.demo.repository.CategoryRepository;

@RestController
@RequestMapping("/api/p1/")
public class CategoryController {
	
	@Autowired CategoryRepository categoryRepository;
	
	@PostMapping("categories")
	public void save(@RequestBody Category category) {
		categoryRepository.save(category);
	}
	
	@GetMapping("categories/{id}")
	public Optional<Category> getById(@PathVariable("id") int id) {
		return categoryRepository.findById(id);
	}
	
	@PutMapping("categories/{categoryid}")
	public void update(@RequestBody Category category,  @PathVariable("categoryid") int categoryid) {
		category.setId(categoryid);
		categoryRepository.save(category);
	}
	
	@DeleteMapping("categories/{id}")
	public void deleteById(@PathVariable("id") int id) {
		categoryRepository.deleteById(id);
	}

	@GetMapping("categories")
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}
	
	@GetMapping("categories/query")
	public Category getByName() {
		return categoryRepository.findByName();
	}
	
	@GetMapping("categories/native")
	public List<Category> getByName( String name) {
		return categoryRepository.findByNames();
	}
	
	@GetMapping("categories/paging")
	public List<Category> getCategories() {
		org.springframework.data.domain.Pageable pageable = PageRequest.of(0, 2);
		List<Category> list = categoryRepository.findCategories(pageable);
		
		return list;
	}
	
	@GetMapping("categories/sorting")
	public List<Category> sortCategory() {
		String sortBy = "id";
		List<Category> list = (List<Category>) categoryRepository.sortCategory(Sort.by(Sort.Direction.DESC,sortBy));
		
		return list;
	}
}