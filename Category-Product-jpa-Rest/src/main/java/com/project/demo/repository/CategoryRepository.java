package com.project.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.demo.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	@Query(value = "Select c from Category c Where c.name = 'Cookies'")
	public Category findByName();
	
	@Query(value = "SELECT * FROM categories Where name like 'Coo%'", nativeQuery = true)
	public List<Category> findByNames(); 
	

	@Query(value = "SELECT c FROM Category c")
	public List<Category> findCategories(Pageable pageable);
	
	@Query("from Category" )
	public Iterable<Category> sortCategory(Sort sort);
}
