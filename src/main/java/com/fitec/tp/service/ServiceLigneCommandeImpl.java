package com.fitec.tp.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fitec.tp.dao.IDaoLigneCommande;
import com.fitec.tp.entity.Commande;
import com.fitec.tp.entity.LigneCommande;


@WebService(endpointInterface="com.fitec.tp.service.IServiceLigneCommande")
@Service
@Transactional // de Spring
public class ServiceLigneCommandeImpl implements IServiceLigneCommande{

	@Autowired
	private IDaoLigneCommande daoLigneCommande;

	@Override
	public LigneCommande rechercherLigneCommande(int id) {
		return daoLigneCommande.selectById(id);
	}

	@Override
	public List<LigneCommande> selectAll() {
		return daoLigneCommande.selectAll();
	}
	
	@Override
	public LigneCommande ajouterLigneCommande(LigneCommande lc) {
		lc = daoLigneCommande.insertLigneCommande(lc);
		return lc;
	}

	@Override
	public List<LigneCommande> rechercherLigneCommandeByCommande(Commande id_commande) {
		return daoLigneCommande.selectByCommande(id_commande);
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
