package com.fitec.tp.entity;

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
@Table(name="Produit")
@NamedQueries({@NamedQuery(name = "produit.all", query = "SELECT p FROM Produit p")})
@XmlType(namespace="http://entity.tp.fitec.com/")  // le nom du package a l'envers
@XmlRootElement(name="produit") 
public class Produit {
	 
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
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name="id_promotion")
	private Promotion promotion;
	
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

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	private String image;
	
	private String image_alt;
	
	@Override
	public String toString() {
		return " [id=" + id + ", libelle=" + libelle + ", categorie=" + categorie + ", prix=" + prix + "]";
	}

	public String getImage_alt() {
		return image_alt;
	}

	public void setImage_alt(String image_alt) {
		this.image_alt = image_alt;
	}
	
}
