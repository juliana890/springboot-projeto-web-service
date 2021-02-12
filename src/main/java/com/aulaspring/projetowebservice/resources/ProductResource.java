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

import com.aulaspring.projetowebservice.entities.Product;
import com.aulaspring.projetowebservice.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	//Nosso controlador rest que responde no caminho categories
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		
		//Para retornar com sucesso
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	//Para inserir nós usamos o método POST
	@PostMapping
	public ResponseEntity<Product> insert(@RequestBody Product obj){
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		//O ideal é retornar o código 201 padrão do HTTP especifico quando se insere algum dado
    	//O created espera um objeto do tipo URI
		return ResponseEntity.created(uri).body(obj);
	}

	//Para deletar nós utilizamos o método DELETE
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		
		//Utilizamos o .noContent pois o retorno não possui conteudo
		return ResponseEntity.noContent().build(); //Código 204
	}
	
	//Para atualizar nós utilizamos o método PUT
	@PutMapping(value = "/{id}")
	public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product obj){
		obj = service.update(id, obj);
		
		return ResponseEntity.ok().body(obj);
	}
}
