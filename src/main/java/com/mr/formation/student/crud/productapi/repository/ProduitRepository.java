package com.mr.formation.student.crud.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mr.formation.student.crud.productapi.entity.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
