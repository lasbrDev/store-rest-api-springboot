package br.com.lasbr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.lasbr.entities.Order;
import br.com.lasbr.repositories.OrderRepository;

@Service
public class OrderService {

	private final OrderRepository repository;
	
	public OrderService(OrderRepository repository) {
		this.repository = repository;
	}	
		
		public List<Order> findAll() {
			return repository.findAll();
		}
		
		public Order findById(Long id) {
			Optional<Order> obj = repository.findById(id);
			return obj.get();
		}
}
