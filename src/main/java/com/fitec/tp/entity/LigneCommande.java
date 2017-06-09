package com.fitec.tp.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name="ligne_commande") // nom exact de la table dans la bdd
@NamedQueries({@NamedQuery(name = "ligne_commande.all", query = "SELECT lc FROM LigneCommande lc")})
@XmlType(namespace="http://entity.tp.fitec.com/")  // le nom du package a l'envers
//@XmlRootElement(name="ligne_commande") // ne sert que pour du xml
public class LigneCommande implements Serializable, IEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_commande")	
	private Commande id_commande;
	
	@ManyToOne
	@JoinColumn(name="id_produit")	
	private Produit id_produit;
	
	private Integer quantite;
	
	private Float prix;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Commande getId_commande() {
		return id_commande;
	}

	public void setId_commande(Commande id_commande) {
		this.id_commande = id_commande;
	}

	public Produit getId_produit() {
		return id_produit;
	}

	public void setId_produit(Produit id_produit) {
		this.id_produit = id_produit;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}
	
}
