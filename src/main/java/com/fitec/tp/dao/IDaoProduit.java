package com.fitec.tp.dao;

import java.util.List;

import com.fitec.tp.entity.Produit;

public interface IDaoProduit {
	
	public List<Produit> selectAll();	
	public Produit selectById(int id);
	
	// + autres methodes CRUD
//	public Produit insertProduit(Produit p); // retourne a avec auto_incr pk
//	public void deleteProduit(int id); // avec RuntimeException si pb
//	public void updateProduit(Produit p);
	
}
