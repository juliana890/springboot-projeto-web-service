package com.aulaspring.projetowebservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulaspring.projetowebservice.entities.Order;
import com.aulaspring.projetowebservice.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		//Para recuperar um pedido pelo id
		Optional<Order> obj = repository.findById(id);
		
		//O get pega o objeto que está dentro do Optional
		return obj.get();
	}

}
