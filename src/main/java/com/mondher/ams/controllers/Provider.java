package com.mondher.ams.controllers;

public class Provider {
	public String nom;
	public String adresse;
	public String mobile;
	
	
	public Provider(String nom, String adresse, String mobile) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.mobile = mobile;
	}
	
	public Provider() {
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	

}
