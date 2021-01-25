package com.aulaspring.projetowebservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulaspring.projetowebservice.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
