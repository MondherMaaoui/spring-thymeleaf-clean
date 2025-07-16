package com.mondher.ams.entities;


import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
@Table(name = "FormateurClasse")
public class FormateurClasse {

    @EmbeddedId
    private FormateurClasseId id;

    @ManyToOne
    @MapsId("formaCode")  // fait référence au champ formaCode dans FormateurClasseId
    @JoinColumn(name = "formaCode")
    private Formateur formateur;

    @ManyToOne
    @MapsId("classeCode")  // fait référence au champ classeCode dans FormateurClasseId
    @JoinColumn(name = "classeCode")
    private Classe classe;

    // Constructeurs, getters et setters

    public FormateurClasseId getId() {
        return id;
    }

    public void setId(FormateurClasseId id) {
        this.id = id;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
}