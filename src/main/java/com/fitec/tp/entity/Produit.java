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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="produit") // nom exact de la table
@NamedQueries({@NamedQuery(name = "produit.all", query = "SELECT p FROM Produit p")})
@XmlType(namespace="http://entity.tp.fitec.com/")  // le nom du package a l'envers
//@XmlRootElement(name="produit") // ne sert que dans du xml
public class Produit implements Serializable, IEntity {
	 
	private static final long serialVersionUID = 1L;
	
	public Produit() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String libelle;
	
	private Float prix;
	
	private String description;
	
	private int stock;
	
	@ManyToOne
	@JoinColumn(name="id_categorie")
	private Categorie id_categorie;
	
	@ManyToOne
	@JoinColumn(name="id_promotion")
	private Promotion id_promotion;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	private String image;
	
	private String image_alt;
	
	@JsonIgnore
	@Override
	public String toString() {
		return " [id=" + id + ", libelle=" + libelle + ", categorie=" + id_categorie + ", prix=" + prix + "]";
	}

	public String getImage_alt() {
		return image_alt;
	}

	public Categorie getId_categorie() {
		return id_categorie;
	}

	public void setId_categorie(Categorie id_categorie) {
		this.id_categorie = id_categorie;
	}

	public Promotion getId_promotion() {
		return id_promotion;
	}

	public void setId_promotion(Promotion id_promotion) {
		this.id_promotion = id_promotion;
	}

	public void setImage_alt(String image_alt) {
		this.image_alt = image_alt;
	}
	
}
