package com.mondher.ams.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mondher.ams.entities.Formateur;

public interface FormateurRepository extends JpaRepository<Formateur, Integer> {
    // méthodes personnalisées si nécessaire
}
