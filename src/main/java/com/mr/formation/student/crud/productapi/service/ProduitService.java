package com.mr.formation.student.crud.productapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.mr.formation.student.crud.productapi.entity.Produit;
import com.mr.formation.student.crud.productapi.repository.ProduitRepository;

@Service
@Primary
public class ProduitService implements ICrudService<Produit, Long> {
	
	@Autowired
	private ProduitRepository produitRepository;

	@Override
	public List<Produit> getAll() {
		return produitRepository.findAll();
	}

	@Override
	public void add(Produit produit) {
		produitRepository.save(produit);
	}

	@Override
	public void update(Produit produit) {
		produitRepository.save(produit);

	}

	@Override
	public void delete(Long id) {
		Produit produit = new Produit();
		produit.setId(id);
		produitRepository.delete(produit);;

	}

}
