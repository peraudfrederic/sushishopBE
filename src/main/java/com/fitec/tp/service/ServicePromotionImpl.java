package com.fitec.tp.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fitec.tp.dao.IDaoPromotion;
import com.fitec.tp.entity.Promotion;

@WebService(endpointInterface="com.fitec.tp.service.IServicePromotion")
@Service
@Transactional // de Spring
public class ServicePromotionImpl implements IServicePromotion{

	@Autowired
	private IDaoPromotion daoPromotion;

	@Override
	public Promotion rechercherPromotion(int id) {
		return daoPromotion.selectById(id);
	}

	@Override
	public List<Promotion> selectAll() {
		return daoPromotion.selectAll();
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
