package com.fitec.tp.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name="categorie") // nom exact de la table dans la bdd
@NamedQueries({@NamedQuery(name = "categorie.all", query = "SELECT c FROM Categorie c")})
@XmlType(namespace="http://entity.tp.fitec.com/")  // le nom du package a l'envers
//@XmlRootElement(name="categorie") // ne sert que pour du xml
public class Categorie implements Serializable, IEntity {
	 
	private static final long serialVersionUID = 1L;
	
	public Categorie() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String libelle;
	
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", libelle=" + libelle + "]";
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
