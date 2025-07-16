package com.mondher.ams.controllers;

import com.mondher.ams.entities.Formateur;
import com.mondher.ams.services.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/formateur")
public class FormateurController {

    @Autowired
    private FormateurService formateurService;

    @GetMapping("/list")
    public String listFormateurs(Model model) {
        List<Formateur> formateurs = formateurService.getAllFormateurs();
        model.addAttribute("formateurs", formateurs);
        return "formateur/list";  // Crée la vue formateur/list.html
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("formateur", new Formateur());
        return "formateur/add";  // Crée la vue formateur/add.html
    }

    @PostMapping("/save")
    public String saveFormateur(@ModelAttribute Formateur formateur) {
        formateurService.saveFormateur(formateur);
        return "redirect:/formateur/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteFormateur(@PathVariable("id") int id) {
        formateurService.deleteFormateur(id);
        return "redirect:/formateur/list";
    }
    
 // Affichage du formulaire de modification
    @GetMapping("/edit/{id}")
    public String afficherFormulaireModification(@PathVariable("id") int id, Model model) {
        Formateur formateur = formateurService.getFormateurById(id);
        if (formateur == null) {
            // Gérer l'erreur si le formateur n'existe pas
            return "redirect:/formateur/list";
        }
        model.addAttribute("formateur", formateur);
        return "formateur/add"; // même vue utilisée pour ajouter et modifier
    }

}

