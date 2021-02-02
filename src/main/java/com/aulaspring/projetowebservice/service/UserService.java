package com.aulaspring.projetowebservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulaspring.projetowebservice.entities.User;
import com.aulaspring.projetowebservice.repositories.UserRepository;

//Para a instancia funcionar a classe precisa estar registrada como um componente do Spring
//@Component para componente
//@Repository para repositório
//Aqui vamos utilizar o @Service pois nossa classe é um serviço
@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		//Para recuperar um usuário pelo id
	 	Optional<User> obj = repository.findById(id);
	 	
	 	//O get pega o objeto que está dentro do Optional
	 	return obj.get();
	}
	
	//Salvar usuário no banco de dados
	public User insert(User obj) {
		return repository.save(obj); //O save já retorna o objeto salvo
	}
	
	//Deletar usuário no banco de dados
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}
