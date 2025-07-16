package com.mondher.ams.entities;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class FormateurClasseId implements Serializable {

    private int formaCode;
    private int classeCode;

    // Constructeur par défaut obligatoire
    public FormateurClasseId() {
    }

    public FormateurClasseId(int formaCode, int classeCode) {
        this.formaCode = formaCode;
        this.classeCode = classeCode;
    }

    // getters et setters
    public int getFormaCode() {
        return formaCode;
    }

    public void setFormaCode(int formaCode) {
        this.formaCode = formaCode;
    }

    public int getClasseCode() {
        return classeCode;
    }

    public void setClasseCode(int classeCode) {
        this.classeCode = classeCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FormateurClasseId)) return false;
        FormateurClasseId that = (FormateurClasseId) o;
        return formaCode == that.formaCode && classeCode == that.classeCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(formaCode, classeCode);
    }
}

