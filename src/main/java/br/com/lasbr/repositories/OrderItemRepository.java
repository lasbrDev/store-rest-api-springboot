package br.com.lasbr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lasbr.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
