package com.fitec.tp.dao;

import com.fitec.tp.entity.Promotion;

public interface IDaoPromotion extends IDao<Promotion> {
	
	public Promotion selectById(int id);
	
	// + autres methodes CRUD
//	public Produit insertProduit(Produit p); // retourne a avec auto_incr pk
//	public void deleteProduit(int id); // avec RuntimeException si pb
//	public void updateProduit(Produit p);
	
}

