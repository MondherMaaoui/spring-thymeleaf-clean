package com.mondher.ams.controllers;

import com.mondher.ams.entities.Classe;
import com.mondher.ams.repositories.ClasseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/classe")
public class ClasseController {

    @Autowired
    private ClasseRepository classeRepository;

    // Liste toutes les classes
    @GetMapping("/list")
    public String listClasses(Model model) {
        model.addAttribute("listeClasses", classeRepository.findAll());
        return "classe/list";  // renvoie templates/classe/list.html
    }

    // Affiche le formulaire d'ajout
    @GetMapping("/add")
    public String addClasse(Model model) {
        model.addAttribute("classe", new Classe());
        return "classe/form"; // renvoie templates/classe/form.html
    }

    // Affiche le formulaire d'édition
    @GetMapping("/edit/{id}")
    public String editClasse(@PathVariable("id") Integer classeCode, Model model) {
        Optional<Classe> optionalClasse = classeRepository.findById(classeCode);
        if (optionalClasse.isPresent()) {
            model.addAttribute("classe", optionalClasse.get());
            return "classe/form";
        } else {
            // classe non trouvée, rediriger vers la liste
            return "redirect:/classe/list";
        }
    }

    // Enregistre une nouvelle classe ou modifie une existante
    @PostMapping("/save")
    public String saveClasse(@ModelAttribute("classe") Classe classe) {
        // Comme classeCode n'est pas auto-incrémenté, il doit être fixé dans le formulaire
        classeRepository.save(classe);
        return "redirect:/classe/list";
    }

    // Supprime une classe
    @GetMapping("/delete/{id}")
    public String deleteClasse(@PathVariable("id") Integer classeCode) {
        classeRepository.deleteById(classeCode);
        return "redirect:/classe/list";
    }
}
