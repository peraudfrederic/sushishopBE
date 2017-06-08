package com.fitec.tp.dao;

import java.util.List;

import com.fitec.tp.entity.Commande;


public interface IDaoCommande extends IDao<Commande> {
	
	public Commande selectById(int id);
	
	// + autres methodes CRUD
//	public Produit insertProduit(Produit p); // retourne a avec auto_incr pk
//	public void deleteProduit(int id); // avec RuntimeException si pb
//	public void updateProduit(Produit p);
	
}