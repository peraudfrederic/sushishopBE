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
import com.fitec.tp.entity.Produit;
import com.fitec.tp.entity.User;


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
	
	
	@Override
	public List<Commande> rechercherCommandeByUser(User id_user) {
		return daoCommande.selectByUser(id_user);
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
