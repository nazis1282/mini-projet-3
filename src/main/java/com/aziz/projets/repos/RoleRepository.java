package com.aziz.projets.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aziz.projets.entities.Role;
public interface RoleRepository extends JpaRepository<Role, Long> {
Role findByRole(String role);
}
