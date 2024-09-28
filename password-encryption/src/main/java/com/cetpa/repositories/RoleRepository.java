package com.cetpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cetpa.entities.UserRole;

public interface RoleRepository extends JpaRepository<UserRole,Integer> 
{
}
