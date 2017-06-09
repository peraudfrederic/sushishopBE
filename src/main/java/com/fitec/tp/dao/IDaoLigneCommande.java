package com.fitec.tp.dao;

import com.fitec.tp.entity.LigneCommande;

public interface IDaoLigneCommande extends IDao<LigneCommande> {
	
	public LigneCommande selectById(int id);
	
	// + autres methodes CRUD
	public LigneCommande insertLigneCommande(LigneCommande lc); // retourne a avec auto_incr pk
//	public void deleteProduit(int id); // avec RuntimeException si pb
//	public void updateProduit(Produit p);
	
}
