package com.aulaspring.projetowebservice.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.aulaspring.projetowebservice.entities.Category;
import com.aulaspring.projetowebservice.repositories.CategoryRepository;
import com.aulaspring.projetowebservice.service.exceptions.DatabaseException;
import com.aulaspring.projetowebservice.service.exceptions.ResourceNotFoundException;

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
	
	//Salvar categoria no banco de dados
	public Category insert(Category obj) {
		return repository.save(obj); //O save já retorna o objeto salvo
	}
	
	//Deletar categoria no banco de dados
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	//Atualizar categoria no banco de dados
	public Category update(Long id, Category obj) {
		try {
			Category entity = repository.getOne(id); //O getOne vai instânciar uma categoria
			updateData(entity, obj);
			return repository.save(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Category entity, Category obj) {
		entity.setName(obj.getName());
		
	}

}
