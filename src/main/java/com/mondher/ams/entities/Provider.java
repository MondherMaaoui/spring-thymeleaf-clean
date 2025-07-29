package com.mondher.ams.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "provider")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // clé primaire auto-incrémentée
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "adresse", length = 200)
    private String adresse;

    @Column(name = "email", length = 100, unique = true)
    private String email;

    // Constructeurs
    public Provider() {
    }

    public Provider(String name, String adresse, String email) {
        this.name = name;
        this.adresse = adresse;
        this.email = email;
    }
    
   

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString()
    @Override
    public String toString() {
        return "Provider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
