package com.mondher.ams.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mondher.ams.entities.FormateurClasse;
import com.mondher.ams.entities.FormateurClasseId;

public interface FormateurClasseRepository extends JpaRepository<FormateurClasse, FormateurClasseId> {
	List<FormateurClasse> findByFormateur_FormaCode(Integer formaCode); // ✅ correct
	List<FormateurClasse> findByClasse_ClasseCode(Integer classeCode);
    List<FormateurClasse> findByClasseClasseCode(Integer classeCode);
}
