package com.mr.formation.student.crud.productapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mr.formation.student.crud.productapi.entity.Produit;

@Service
public class ProduitMockServiceImpl implements IProduitService {
	
	private List<Produit> produits;
	
	public ProduitMockServiceImpl() {
		produits = new ArrayList<Produit>();
		
		produits.add(new Produit("Livre", 50, 20));
		produits.add(new Produit("Cahier", 200, 5.25f));
		produits.add(new Produit("Stylo", 500, 2.10f));
	}

	@Override
	public List<Produit> getProduits() {
		return produits;
	}

	@Override
	public void addProduit(Produit produit) {
		produits.add(produit);
	}

	@Override
	public void updateProduit(Produit produit) {
		produits.remove(produit);
		produits.add(produit);
	}

	@Override
	public void deleteProduit(Long id) {
		Produit produit= new Produit();
		produit.setId(id);
		produits.remove(produit);

	}

}
