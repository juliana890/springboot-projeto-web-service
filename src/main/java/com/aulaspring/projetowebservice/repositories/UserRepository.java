package com.aulaspring.projetowebservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulaspring.projetowebservice.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
