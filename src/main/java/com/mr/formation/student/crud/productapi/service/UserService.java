package com.mr.formation.student.crud.productapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.mr.formation.student.crud.productapi.entity.Produit;
import com.mr.formation.student.crud.productapi.entity.User;
import com.mr.formation.student.crud.productapi.repository.ProduitRepository;
import com.mr.formation.student.crud.productapi.repository.UserRepository;

@Service
@Primary
public class UserService implements ICrudService<User, Long> {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public void add(User user) {
		userRepository.save(user);
	}

	@Override
	public void update(User user) {
		userRepository.save(user);

	}

	@Override
	public void delete(Long id) {
		User user = new User();
		user.setId(id);
		userRepository.delete(user);;

	}

}
