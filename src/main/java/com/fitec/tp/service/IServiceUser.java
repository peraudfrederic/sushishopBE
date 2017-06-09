package com.fitec.tp.service;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.fitec.tp.entity.Produit;
import com.fitec.tp.entity.User;

@WebService
public interface IServiceUser extends IService<User>{

	public User ajouterUser(@WebParam(name="user")User user);
	
	public User seConnecter(@WebParam(name="user")User user);
	
	public User rechercherUser(@WebParam(name="id")int id);
}
