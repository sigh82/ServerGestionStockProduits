package com.mr.formation.student.crud.productapi.service;

import java.util.List;

import com.mr.formation.student.crud.productapi.entity.Produit;

public interface ICrudService<T, ID> {
	
	List<T> getAll();
	
	void  add(T entity);
	
	void update(T entity);
	
	void delete(ID id);

}
