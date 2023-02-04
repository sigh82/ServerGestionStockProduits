package com.mr.formation.student.crud.productapi.service;

import java.util.List;

import com.mr.formation.student.crud.productapi.entity.Produit;

public interface IProduitService {
	
	List<Produit> getProduits();
	
	void  addProduit(Produit produit);
	
	void updateProduit(Produit produit);
	
	void deleteProduit(Long id);

}
