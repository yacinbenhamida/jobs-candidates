package com.esprit.models;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;


@Entity
public class Candidat implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@javax.persistence.Id
	@GeneratedValue
	private int Id;
	private String nom, prenom, email;
	public Candidat() {
		// TODO Auto-generated constructor stub
	}
	
	public Candidat(String prenom) {
		super();
		this.prenom = prenom;
	}

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Candidat [nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}
	
	
}
