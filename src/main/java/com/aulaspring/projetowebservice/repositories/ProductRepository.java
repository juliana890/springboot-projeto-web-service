package com.aulaspring.projetowebservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulaspring.projetowebservice.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
