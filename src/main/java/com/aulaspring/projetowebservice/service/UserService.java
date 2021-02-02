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

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		// Para recuperar um usuário pelo id
		Optional<User> obj = repository.findById(id);

		// O get pega o objeto que está dentro do Optional
		return obj.get();
	}

	// Salvar usuário no banco de dados
	public User insert(User obj) {
		return repository.save(obj); // O save já retorna o objeto salvo
	}

	// Deletar usuário no banco de dados
	public void delete(Long id) {
		repository.deleteById(id);
	}

	//Atualizar usuário no banco de dados
	public User update(Long id, User obj) {
		User entity = repository.getOne(id); //O getOne vai instânciar um usuário
		updateData(entity, obj); //Método que irá atualizar o usuário
		return repository.save(entity); //Salvamos a alteração no banco de dados
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
