package com.fitec.tp.dao;

import java.util.List;

import com.fitec.tp.entity.Commande;
import com.fitec.tp.entity.LigneCommande;
import com.fitec.tp.entity.User;

public interface IDaoLigneCommande extends IDao<LigneCommande> {
	
	public LigneCommande selectById(int id);
	
	public List<LigneCommande> selectByCommande(Commande id_commande);
	
	// + autres methodes CRUD
	public LigneCommande insertLigneCommande(LigneCommande lc); // retourne a avec auto_incr pk
//	public void deleteProduit(int id); // avec RuntimeException si pb
//	public void updateProduit(Produit p);
	
}
