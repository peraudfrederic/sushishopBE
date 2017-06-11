package com.fitec.tp.dao;

import java.util.List;

import com.fitec.tp.entity.Commande;
import com.fitec.tp.entity.User;


public interface IDaoCommande extends IDao<Commande> {
	
	public Commande selectById(int id);
	
	public List<Commande> selectByUser(User id_user);
	
	// + autres methodes CRUD
	public Commande insertCommande(Commande c); // retourne c avec auto_incr pk
//	public void deleteProduit(int id); // avec RuntimeException si pb
//	public void updateProduit(Produit p);
	
}