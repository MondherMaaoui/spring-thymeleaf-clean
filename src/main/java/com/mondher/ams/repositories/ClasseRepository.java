package com.mondher.ams.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mondher.ams.entities.Classe;

public interface ClasseRepository extends JpaRepository<Classe, Integer> {
    // tu peux ajouter des méthodes personnalisées ici si besoin
}

