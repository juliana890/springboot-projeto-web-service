package com.aulaspring.projetowebservice.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	//Para inserir nós usamos o método POST
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){
    	obj = service.insert(obj);
    	
    	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    	
    	//O ideal é retornar o código 201 padrão do HTTP especifico quando se insere algum dado
    	//O created espera um objeto do tipo URI
    	return ResponseEntity.created(uri).body(obj);
    }
    
    //Para deletar nós usamos o método DELETE
    //Usamos o tipo Void pois não precisamos de nenhum retorno
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
    	service.delete(id);
    	
    	//Utilizamos o .noContent pois o retorno não possui conteúdo
    	return ResponseEntity.noContent().build(); //Código 204
    }
    
    //Para atualizar utilizamos o método PUT
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
    	obj = service.update(id, obj);
    	return ResponseEntity.ok().body(obj);
    }
    
}
