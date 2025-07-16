package com.mondher.ams.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mondher.ams.entities.Classe;
import com.mondher.ams.repositories.ClasseRepository;

@Service
public class ClasseService {

    @Autowired
    private ClasseRepository classeRepository;

    public List<Classe> getAllClasses() {
        return classeRepository.findAll();
    }

    public Classe saveClasse(Classe classe) {
        return classeRepository.save(classe);
    }

    public Classe getClasseById(Integer id) {
        return classeRepository.findById(id).orElse(null);
    }

    public void deleteClasse(Integer id) {
        classeRepository.deleteById(id);
    }
}
