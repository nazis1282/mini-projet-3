package com.aziz.projets.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aziz.projets.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}