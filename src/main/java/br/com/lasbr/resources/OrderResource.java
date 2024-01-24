package br.com.lasbr.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lasbr.entities.Order;
import br.com.lasbr.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

		private final OrderService service;
		
		public OrderResource(OrderService service) {
			this.service = service;
		}
		
		@GetMapping
		public ResponseEntity<List<Order>> findAll() {
			List<Order> list = service.findAll();
			return ResponseEntity.ok().body(list);
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Order> findById(@PathVariable Long id) {
			Order order = service.findById(id);
			return ResponseEntity.ok().body(order);
		}
}
