package com.esprit.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
@Entity
public class Job implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@javax.persistence.Id
	@GeneratedValue
	private int Id;
	
	private String service;
	private boolean etat;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	@Override
	public String toString() {
		return "Job [Id=" + Id + ", service=" + service + ", etat=" + etat + "]";
	}
	public Job(String service, boolean etat) {
		super();
		this.service = service;
		this.etat = etat;
	}
	public Job() {
		// TODO Auto-generated constructor stub
	}
	
}
