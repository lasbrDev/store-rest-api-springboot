package br.com.lasbr.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.lasbr.entities.Category;
import br.com.lasbr.entities.Order;
import br.com.lasbr.entities.OrderItem;
import br.com.lasbr.entities.Payment;
import br.com.lasbr.entities.Product;
import br.com.lasbr.entities.User;
import br.com.lasbr.entities.enums.OrderStatus;
import br.com.lasbr.repositories.CategoryRepository;
import br.com.lasbr.repositories.OrderItemRepository;
import br.com.lasbr.repositories.OrderRepository;
import br.com.lasbr.repositories.ProductRepository;
import br.com.lasbr.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	private final UserRepository userRepository;

	private final OrderRepository orderRepository;

	private final CategoryRepository categoryRepository;

	private final ProductRepository productRepository;
	
	private final OrderItemRepository orderItemRepository;

	public TestConfig(UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository, 
			ProductRepository productRepository, OrderItemRepository orderItemRepository) {

		this.userRepository = userRepository;
		this.orderRepository = orderRepository;
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		this.orderItemRepository = orderItemRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		User user1 = new User(null, "Maria Brown", "maria@gmail.com", "99999999", "12345");
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "779944558", "987654");

		Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.DELIVERED, user1);
		Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID, user2);
		Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, user1);

		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
		
		OrderItem ord1 = new OrderItem(order1, p1, 2, p1.getPrice());
		OrderItem ord2 = new OrderItem(order1, p3, 1, p4.getPrice());
		OrderItem ord3 = new OrderItem(order2, p3, 2, p1.getPrice());
		OrderItem ord4 = new OrderItem(order3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(ord1, ord2,ord3, ord4));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-07-21T05:42:10Z"), order2);
		order2.setPayment(pay1);
		orderRepository.save(order2);
	}
}
