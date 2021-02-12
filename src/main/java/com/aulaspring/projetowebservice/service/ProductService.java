package com.aulaspring.projetowebservice.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.aulaspring.projetowebservice.entities.Product;
import com.aulaspring.projetowebservice.repositories.ProductRepository;
import com.aulaspring.projetowebservice.service.exceptions.DatabaseException;
import com.aulaspring.projetowebservice.service.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		//Para recuperar um produto pelo id
		Optional<Product> obj = repository.findById(id);
		
		//O get pega o objeto que está dentro do optional
		return obj.get();
		
	}
	
	//Salvar produto no banco de dados
	public Product insert(Product obj) {
		return repository.save(obj);
	}
	
	//Deletar produto no banco de dados
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
	
	//Atualizar produto no banco de dados
	public Product update(Long id, Product obj) {
		try {
		   Product entity = repository.getOne(id); //O getOne vai instânciar um produto
		   updateData(entity, obj);
		   return repository.save(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Product entity, Product obj) {
		entity.setName(obj.getName());
		entity.setDescription(obj.getDescription());
		entity.setPrice(obj.getPrice());
		entity.setImgUrl(obj.getImgUrl());
	}
	
}
