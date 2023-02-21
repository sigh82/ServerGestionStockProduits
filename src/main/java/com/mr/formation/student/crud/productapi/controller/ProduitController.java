package com.mr.formation.student.crud.productapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mr.formation.student.crud.productapi.entity.Produit;
import com.mr.formation.student.crud.productapi.service.IProduitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api/produit")
@CrossOrigin
public class ProduitController {
	
    private final Logger log = LoggerFactory.getLogger(ProduitController.class);

	
	@Autowired
	private IProduitService produitService;
	
	@GetMapping
	public List<Produit> getProduits(){
		log.info("REST request to get all Produits : {}");
		return produitService.getProduits();
	}
	
	@PostMapping
	public void addProduit(@RequestBody Produit produit) {
        log.info("REST request to save Produit : {}", produit);
		produitService.addProduit(produit);
	}
	
	@PutMapping
	public void updateProduit(@RequestBody Produit produit) {
		log.info("REST request to update Produit : {}", produit);
		produitService.updateProduit(produit);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduit(@PathVariable Long id) {
		log.info("REST request to delete Produit : {}", id);
		produitService.deleteProduit(id);
	}
	
	

}
