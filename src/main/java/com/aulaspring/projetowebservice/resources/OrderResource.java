package com.aulaspring.projetowebservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulaspring.projetowebservice.entities.Order;
import com.aulaspring.projetowebservice.service.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService service;
	
	//Nosso controlador rest que responde no caminho orders
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		
		//Para retornar resposta com sucesso
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
