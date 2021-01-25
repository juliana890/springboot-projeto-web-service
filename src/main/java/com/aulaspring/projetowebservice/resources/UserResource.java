package com.aulaspring.projetowebservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulaspring.projetowebservice.entities.User;
import com.aulaspring.projetowebservice.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	//Nosso controlador rest que responde no caminho users
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		
		//Para retornar resposta com sucesso
		return ResponseEntity.ok().body(list);
	}
	
	//Pro Spring aceitar o id colocamos a notação antes de declarar o Long
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	

}
