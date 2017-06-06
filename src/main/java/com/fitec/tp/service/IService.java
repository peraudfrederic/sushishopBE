package com.fitec.tp.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.fitec.tp.entity.User;

public interface IService<IEntity> {

	List<IEntity> selectAll();
	
	//Auteur rechercherAuteur(@WebParam(name="id")int id);
	
	//Auteur ajouterAuteur(@WebParam(name="auteur")Auteur auteur);
	
	//void majAuteur(@WebParam(name="auteur")Auteur auteur);
	
	//void supprimerAuteur(@WebParam(name="id")int id);
}
