package com.fitec.tp.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.fitec.tp.entity.Produit;

@WebService
// @WebService et @WebParam est pris en compte pour un web service soap
// et ignoré sur un service interne (ici Spring) injecté dans l'adaptateur REST
public interface IServiceProduit {
	
	Produit rechercherProduit(@WebParam(name="id")int id);
	
	List<Produit> tousLesProduits();
	
//	Produit ajouterProduit(@WebParam(name="produit")Produit p);
//	
//	void majProduit(@WebParam(name="produit")Produit p);
//	
//	void supprimerProduit(@WebParam(name="idProduit")int idProduit);
	
	
}
