package com.aulaspring.projetowebservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulaspring.projetowebservice.entities.Category;
import com.aulaspring.projetowebservice.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		//Para recuperar uma categoria pelo id
		Optional<Category> obj = repository.findById(id);
		
		//O get pega o objeto que está dentro do optional
		return obj.get();
		
	}

}
