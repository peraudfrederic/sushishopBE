package com.fitec.tp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="commande")
@NamedQueries({
	@NamedQuery(name = "commande.all", query = "SELECT c FROM Commande c"),
	@NamedQuery(name = "commande.idUser", query = "SELECT c FROM Commande c WHERE c.id_user = :id_user")
})
@XmlType(namespace="http://entity.tp.fitec.com/")  // le nom du package a l'envers
@XmlRootElement(name="commande") 
public class Commande implements Serializable, IEntity {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	@ManyToOne
	@JoinColumn(name="id_user")
//	private Integer id_user;
	private User id_user;

	public User getId_user() {
		return id_user;
	}

	public void setId_user(User id_user) {
		this.id_user = id_user;
	}

	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@JsonIgnore
    @OneToMany
    @JoinColumn(name="id")
	private Set<LigneCommande> lignesCommande;	
	
	public Set<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	public void setLignesCommande(Set<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	@JsonIgnore
	@Override
	public String toString() {
		return " [id=" + id + ", id_user=" + id_user + ", date=" + date + "]";
	}
	
	@JsonIgnore
	public String toStringLignes() {
		return lignesCommande.toString();
	}
	
}
