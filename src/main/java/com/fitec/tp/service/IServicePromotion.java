package com.fitec.tp.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.fitec.tp.entity.Promotion;

@WebService
// @WebService et @WebParam est pris en compte pour un web service soap
// et ignor� sur un service interne (ici Spring) inject� dans l'adaptateur REST
public interface IServicePromotion extends IService<Promotion> {
	
	Promotion rechercherPromotion(@WebParam(name="id")int id);
	
	List<Promotion> selectAll();
	
//	Produit ajouterProduit(@WebParam(name="produit")Produit p);
//	
//	void majProduit(@WebParam(name="produit")Produit p);
//	
//	void supprimerProduit(@WebParam(name="idProduit")int idProduit);
	
	
}
