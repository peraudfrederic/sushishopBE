package com.fitec.tp.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fitec.tp.dao.IDaoUser;
import com.fitec.tp.entity.User;



@Service // pa d�faut id = calculateurImpl (nom de la classe avcec minuscule au d�but
@WebService(endpointInterface="com.fitec.tp.service.ServiceUser")
@Transactional  //de spring
public class ServiceUserImpl implements IServiceUser {

	@Autowired
	private IDaoUser daoUser;
	
	/*@Override
	public Auteur rechercherAuteur(int id) {
		return daoAuteur.selectById(id);
	}*/

	public List<User> selectAll() {
		return daoUser.selectAll();
	}

	/*@Override*/
	public User ajouterUser(User user) {
		return daoUser.insert(user);
	}
	
	public User seConnecter(User user) {
		
		User dbUser = daoUser.selectByEmail(user.getEmail());
		
		if (dbUser == null || !dbUser.getMdp().equals(user.getMdp()))
			dbUser = null;
		
		return dbUser;	
	}
	
/*
	@Override
	public void majAuteur(Auteur auteur) {
		daoAuteur.updateAuteur(auteur);
	}

	@Override
	public void supprimerAuteur(int id) {
		daoAuteur.deleteAuteur(id);
	}*/

}
