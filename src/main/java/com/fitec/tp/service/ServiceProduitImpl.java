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
