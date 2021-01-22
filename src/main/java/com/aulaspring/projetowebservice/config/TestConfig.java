package com.aulaspring.projetowebservice.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aulaspring.projetowebservice.entities.User;
import com.aulaspring.projetowebservice.repositories.UserRepository;

//Especificando que é uma classe de configuração
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	//Para resolver a dependencia e associar a instância do UserRepository
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//Para salvar no banco de dados passamos uma lista de objetos
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	
}
