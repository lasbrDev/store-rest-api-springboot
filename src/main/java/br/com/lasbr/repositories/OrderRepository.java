package br.com.lasbr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lasbr.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
