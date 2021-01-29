package com.aulaspring.projetowebservice.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aulaspring.projetowebservice.entities.Category;
import com.aulaspring.projetowebservice.entities.Order;
import com.aulaspring.projetowebservice.entities.User;
import com.aulaspring.projetowebservice.entities.enums.OrderStatus;
import com.aulaspring.projetowebservice.repositories.CategoryRepository;
import com.aulaspring.projetowebservice.repositories.OrderRepository;
import com.aulaspring.projetowebservice.repositories.UserRepository;

//Especificando que é uma classe de configuração
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	//Para resolver a dependencia e associar a instância do UserRepository
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		//Para salvar no banco de dados passamos uma lista de objetos
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
	
}
