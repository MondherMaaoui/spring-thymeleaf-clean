package com.mondher.ams.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Contact {
	
	private int id;
	private String titre;
	private String message;
	private LocalDateTime dateMessage;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	
	public Contact(int id, String titre, String message, LocalDateTime dateMessage) {
		super();
		this.id = id;
		this.titre = titre;
		this.message = message;
		this.dateMessage = dateMessage;
	}
	
	public Contact( String titre, String message, LocalDateTime dateMessage) {
		
		
		this.titre = titre;
		this.message = message;
		this.dateMessage = dateMessage;
	}
	
	

	public LocalDateTime getDateMessage() {
		return dateMessage;
	}

	public void setDateMessage(LocalDateTime dateMessage) {
		this.dateMessage = dateMessage;
	}

	public Contact() {
		
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", titre=" + titre + ", message=" + message + ", dateMessage=" + dateMessage + "]";
	}
	

	
}
