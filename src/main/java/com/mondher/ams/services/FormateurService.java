package com.mondher.ams.services;

import com.mondher.ams.entities.Formateur;
import com.mondher.ams.repositories.FormateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormateurService {

    @Autowired
    private FormateurRepository formateurRepository;

    public List<Formateur> getAllFormateurs() {
        return formateurRepository.findAll();
    }

    public Formateur saveFormateur(Formateur f) {
        return formateurRepository.save(f);
    }

   

    public void deleteFormateur(int id) {
        formateurRepository.deleteById(id);
    }
    
    public Formateur getFormateurById(int id) {
        return formateurRepository.findById(id).orElse(null);
    }

}
