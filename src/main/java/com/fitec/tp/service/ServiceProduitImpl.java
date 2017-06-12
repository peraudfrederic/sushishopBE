package com.fitec.tp.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fitec.tp.dao.IDaoProduit;
import com.fitec.tp.entity.Produit;


@WebService(endpointInterface="com.fitec.tp.service.IServiceProduit")
@Service
@Transactional // de Spring
public class ServiceProduitImpl implements IServiceProduit{

	@Autowired
	private IDaoProduit daoProduit;

	@Override
	public Produit rechercherProduit(int id) {
		return daoProduit.selectById(id);
	}

	@Override
	public List<Produit> selectAll() {
		return daoProduit.selectAll();
	}

//	@Override
//	public Produit rechercherProduitByIdProduitLigneCommande(Produit idProduit) {
//		return daoProduit.selectByIdProduitLigneCommande(idProduit);
//	}
	
	// Mise a jour du stock suite à une commande :
	public void majStock(Produit idProduit, int quantiteCommandee){
		int stockMaj = idProduit.getStock() - quantiteCommandee;
		idProduit.setStock(stockMaj);
		daoProduit.updateProduit(idProduit);				
	}

	@Override
	public boolean verifierStock(Produit idProduit, int quantiteCommandee) {
		boolean stockOK = false;
		int etatStock = idProduit.getStock(); // quantite en stock
		
		if(quantiteCommandee <= etatStock){
			stockOK = true;
		}		
		return stockOK;
	}
	
//	@Override
//	public Auteur rechercherAuteur(int id) {
//		return daoAuteur.selectById(id);
//	}
//
//	@Override
//	public List<Auteur> tousLesAuteurs() {
//		return daoAuteur.selectAll();
//	}
//
//	@Override
//	public Auteur ajouterAuteur(Auteur a) {
//		daoAuteur.insertAuteur(a);
//		return a;
//	}
//
//	@Override
//	public void majAuteur(Auteur a) {
//		daoAuteur.updateAuteur(a);		
//	}
//
//	@Override
//	public void supprimerAuteur(int idAuteur) {
//		daoAuteur.deleteAuteur(idAuteur);		
//	}
//	
	

}
