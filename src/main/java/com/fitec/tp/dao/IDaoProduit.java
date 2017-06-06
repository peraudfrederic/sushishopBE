package com.fitec.tp.dao;

import java.util.List;

import com.fitec.tp.entity.Produit;
import com.fitec.tp.entity.User;

public interface IDaoProduit extends IDao<Produit> {
	
	public Produit selectById(int id);
	
	// + autres methodes CRUD
//	public Produit insertProduit(Produit p); // retourne a avec auto_incr pk
//	public void deleteProduit(int id); // avec RuntimeException si pb
//	public void updateProduit(Produit p);
	
}
