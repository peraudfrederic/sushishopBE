package com.fitec.tp.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class LigneCommande implements Serializable, IEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Integer idCommande;
	private Integer idProduit;
	private Float prix;
	private Integer quantite;
	
	@ManyToOne
	@JoinColumn(name="id_Commande")
	private Commande commande;
	
	@ManyToOne
	@JoinColumn(name="id_Produit")
	private Produit produit;
}
