package com.fitec.tp.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fitec.tp.dao.IDaoCommande;
import com.fitec.tp.entity.Commande;
import com.fitec.tp.entity.LigneCommande;
import com.fitec.tp.entity.Panier;
import com.fitec.tp.entity.Produit;


@WebService(endpointInterface="com.fitec.tp.service.IServiceCommande")
@Service
@Transactional // de Spring
public class ServiceCommandeImpl implements IServiceCommande{

	@Autowired
	private IDaoCommande daoCommande;

	@Override
	public Commande rechercherCommande(int id) {
		return daoCommande.selectById(id);
	}

	@Override
	public List<Commande> selectAll() {
		return daoCommande.selectAll();
	}

	@Override
	public Commande ajouterCommande(Commande c) {
		c = daoCommande.insertCommande(c);
		return c;
	}
	
	// Enregistrer le panier
	public void enregistrerPanier(Panier panier){	
		
		Date date = new Date();
		
		Commande newCommande = new Commande();
		newCommande.setId_user(panier.getId_user());
		newCommande.setDate(date);
		
		List<LigneCommande> listeLignesCommandes = panier.getListeLignesCommandes();
		
		//methode 2 -----------------------
		for(LigneCommande lc : listeLignesCommandes)
		{
			LigneCommande newLigneCommande = new LigneCommande(lc.getId(), lc.getId_commande(), lc.getId_produit(), lc.getQuantite(), lc.getPrix());
			newCommande.getLignesCommande().add(newLigneCommande);
		}
		daoCommande.insertCommande(newCommande);   // a priori va inserer les lignes commandes + la commande en bdd
		
		//return newCommande;			
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
