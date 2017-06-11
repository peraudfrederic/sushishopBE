package com.fitec.tp.entity;

import java.io.Serializable;
import java.util.List;


public class Panier implements Serializable, IEntity {

	List<LigneCommande> listeLignesCommandes;

	User id_user;
//	int id_user;

	public List<LigneCommande> getListeLignesCommandes() {
		return listeLignesCommandes;
	}

	public void setListeLignesCommandes(List<LigneCommande> listeLignesCommandes) {
		this.listeLignesCommandes = listeLignesCommandes;
	}

	public User getId_user() {
		return id_user;
	}

	public void setId_user(User id_user) {
		this.id_user = id_user;
	}

}
