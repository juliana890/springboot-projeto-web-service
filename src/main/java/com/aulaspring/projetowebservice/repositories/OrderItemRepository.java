package com.aulaspring.projetowebservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulaspring.projetowebservice.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
