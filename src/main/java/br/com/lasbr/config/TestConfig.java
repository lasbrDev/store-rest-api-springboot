package br.com.lasbr.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.lasbr.entities.User;
import br.com.lasbr.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User user1 = new User(null, "Maria Brown", "maria@gmail.com", "99999999", "12345");
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "779944558", "987654");
		
		userRepository.saveAll(Arrays.asList(user1, user2));
	}
	
	
}
