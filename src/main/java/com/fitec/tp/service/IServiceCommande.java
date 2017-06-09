package com.fitec.tp.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.fitec.tp.entity.Commande;
import com.fitec.tp.entity.Panier;


@WebService
// @WebService et @WebParam est pris en compte pour un web service soap
// et ignor� sur un service interne (ici Spring) inject� dans l'adaptateur REST
public interface IServiceCommande extends IService<Commande> {
	
	Commande rechercherCommande(@WebParam(name="id")int id);
	
	List<Commande> selectAll();
	
	Commande ajouterCommande(@WebParam(name="commande")Commande c);
	
	void enregistrerPanier(@WebParam(name="panier")Panier panier);
//	
//	void majProduit(@WebParam(name="produit")Produit p);
//	
//	void supprimerProduit(@WebParam(name="idProduit")int idProduit);
	
	
}
