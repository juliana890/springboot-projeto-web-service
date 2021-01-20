package com.aulaspring.projetowebservice.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulaspring.projetowebservice.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	//Nosso controlador rest que responde no caminho users
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "maria@gmail.com", "99999999", "12345");
		
		//Para retornar resposta com sucesso
		return ResponseEntity.ok().body(u);
	}

}
