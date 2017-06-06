package com.fitec.tp.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.fitec.tp.entity.Produit;
import com.fitec.tp.entity.User;

@WebService
// @WebService et @WebParam est pris en compte pour un web service soap
// et ignoré sur un service interne (ici Spring) injecté dans l'adaptateur REST
public interface IServiceProduit extends IService<Produit> {
	
	Produit rechercherProduit(@WebParam(name="id")int id);
	
	List<Produit> selectAll();
	
//	Produit ajouterProduit(@WebParam(name="produit")Produit p);
//	
//	void majProduit(@WebParam(name="produit")Produit p);
//	
//	void supprimerProduit(@WebParam(name="idProduit")int idProduit);
	
	
}
