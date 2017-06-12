package com.fitec.tp.entity;

import java.io.Serializable;
import java.util.List;


public class LignePanier implements Serializable, IEntity {

	private int id;
	private int idCommande;
	private int idProduit;
	private int quantite;
	private float prix;
	private int idUser;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProdui) {
		this.idProduit = idProdui;
	}
	
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

}
