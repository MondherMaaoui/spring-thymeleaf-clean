package com.mondher.ams.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mondher.ams.entities.FormateurClasse;
import com.mondher.ams.entities.FormateurClasseId;
import com.mondher.ams.repositories.FormateurClasseRepository;

@Service
public class FormateurClasseService {

    private final FormateurClasseRepository repository;

    public FormateurClasseService(FormateurClasseRepository repository) {
        this.repository = repository;
    }

    public List<FormateurClasse> getAll() {
        return repository.findAll();
    }

    

    public FormateurClasse save(FormateurClasse formateurClasse) {
        return repository.save(formateurClasse);
    }

    public void deleteById(FormateurClasseId id) {
        repository.deleteById(id);
    }
    
    public FormateurClasse getById(FormateurClasseId id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aucune relation trouvée pour l'id " + id));
    }
    
    


}
