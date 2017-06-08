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
@Table(name="Promotion")
@NamedQueries({@NamedQuery(name = "promotion.all", query = "SELECT p FROM Promotion p")})
@XmlType(namespace="http://entity.tp.fitec.com/")  // le nom du package a l'envers
@XmlRootElement(name="promotion") 
public class Promotion implements Serializable, IEntity {
	 
	private static final long serialVersionUID = 1L;
	
	public Promotion() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String reduction;
	
	@Override
	public String toString() {
		return "Promotion [id=" + id + ", reduction=" + reduction + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReduction() {
		return reduction;
	}

	public void setReduction(String reduction) {
		this.reduction = reduction;
	}
	
}
