package com.aulaspring.projetowebservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulaspring.projetowebservice.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
