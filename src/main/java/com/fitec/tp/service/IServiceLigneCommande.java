package com.fitec.tp.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.fitec.tp.entity.LigneCommande;


@WebService
// @WebService et @WebParam est pris en compte pour un web service soap
// et ignor� sur un service interne (ici Spring) inject� dans l'adaptateur REST
public interface IServiceLigneCommande extends IService<LigneCommande> {
	
	LigneCommande rechercherLigneCommande(@WebParam(name="id")int id);
	
	List<LigneCommande> selectAll();
	
	LigneCommande ajouterLigneCommande(@WebParam(name="produit")LigneCommande lc);
//	
//	void majProduit(@WebParam(name="produit")Produit p);
//	
//	void supprimerProduit(@WebParam(name="idProduit")int idProduit);
	
	
}
