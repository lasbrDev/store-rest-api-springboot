package br.com.lasbr.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.lasbr.entities.Category;
import br.com.lasbr.entities.Order;
import br.com.lasbr.entities.User;
import br.com.lasbr.entities.enums.OrderStatus;
import br.com.lasbr.repositories.CategoryRepository;
import br.com.lasbr.repositories.OrderRepository;
import br.com.lasbr.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	private final UserRepository userRepository;
	
	private final OrderRepository orderRepository;
	
	private final CategoryRepository categoryRepository;

	public TestConfig(UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository) {
		this.userRepository = userRepository;
		this.orderRepository = orderRepository;
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		User user1 = new User(null, "Maria Brown", "maria@gmail.com", "99999999", "12345");
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "779944558", "987654");
		
		Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.DELIVERED, user1);
		Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID, user2);
		Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, user1);
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
	}
}
