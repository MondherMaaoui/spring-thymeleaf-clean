package com.mondher.ams.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Classe {

    @Id
    @Column(name = "classeCode")
    private Integer classeCode;  // pas d'autoincrement ici

    @Column(name = "classeLib")
    private String classeLib;

    @Column(name = "classeNbrEleves")
    private Integer classeNbrEleves;

    // Getters & Setters
    public Integer getClasseCode() { return classeCode; }
    public void setClasseCode(Integer classeCode) { this.classeCode = classeCode; }

    public String getClasseLib() { return classeLib; }
    public void setClasseLib(String classeLib) { this.classeLib = classeLib; }

    public Integer getClasseNbrEleves() { return classeNbrEleves; }
    public void setClasseNbrEleves(Integer classeNbrEleves) { this.classeNbrEleves = classeNbrEleves; }
}
