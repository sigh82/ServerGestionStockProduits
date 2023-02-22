package com.mr.formation.student.crud.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mr.formation.student.crud.productapi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	User findByUsername(String username);
}
