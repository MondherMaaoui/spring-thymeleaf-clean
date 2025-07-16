package com.mondher.ams.entities;


import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Formateur {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "formaCode")  // 👈 nom exact souhaité
    private Integer formaCode;

    @Column(name = "formaNom")
    private String formaNom;

    @Column(name = "formaPrenom")
    private String formaPrenom;

    @Column(name = "formaDateNaiss")
    private LocalDate formaDateNaiss;

    // Getters & Setters
    public Integer getFormaCode() {  return this.formaCode ; }
    public void setFormaCode(Integer formaCode) { this.formaCode = formaCode; }

    public String getFormaNom() { return formaNom; }
    public void setFormaNom(String formaNom) { this.formaNom = formaNom; }

    public String getFormaPrenom() { return formaPrenom; }
    public void setFormaPrenom(String formaPrenom) { this.formaPrenom = formaPrenom; }

    public LocalDate getFormaDateNaiss() { return formaDateNaiss; }
    public void setFormaDateNaiss(LocalDate formaDateNaiss) { this.formaDateNaiss = formaDateNaiss; }
}
