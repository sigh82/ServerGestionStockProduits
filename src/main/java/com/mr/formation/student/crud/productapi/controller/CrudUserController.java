package com.mr.formation.student.crud.productapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mr.formation.student.crud.productapi.entity.User;
import com.mr.formation.student.crud.productapi.service.ICrudService;

@RestController
@RequestMapping(name="/crud_user")
public class CrudUserController {
	
    private final Logger log = LoggerFactory.getLogger(CrudUserController.class);
	
	@Autowired
	private ICrudService<User, Long> crudService;
	
	@GetMapping
	public List<User> getProduits(){
		log.info("REST request to get all users : {}");
		return crudService.getAll();
	}
	
	@PostMapping
	public void addProduit(@RequestBody User user) {
        log.info("REST request to save Produit : {}", user);
		crudService.add(user);
	}
	
	@PutMapping
	public void updateProduit(@RequestBody User user) {
		log.info("REST request to update Produit : {}", user);
		crudService.update(user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduit(@PathVariable Long id) {
		log.info("REST request to delete Produit : {}", id);
		crudService.delete(id);
	}
	
	


}
