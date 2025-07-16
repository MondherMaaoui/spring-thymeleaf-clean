package com.mondher.ams.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.mondher.ams.entities.FormateurClasse;
import com.mondher.ams.entities.FormateurClasseId;
import com.mondher.ams.repositories.ClasseRepository;
import com.mondher.ams.repositories.FormateurClasseRepository;
import com.mondher.ams.repositories.FormateurRepository;
import com.mondher.ams.entities.Formateur;
import com.mondher.ams.entities.Classe;
import com.mondher.ams.services.FormateurClasseService;
import com.mondher.ams.services.FormateurService;
import com.mondher.ams.services.ClasseService;

@Controller
@RequestMapping("/formateurClasse")
public class FormateurClasseController {

    private final FormateurClasseService formateurClasseService;
    private final FormateurService formateurService;
    private final ClasseService classeService;
    
    @Autowired
    private FormateurRepository formateurRepository;

    @Autowired
    private ClasseRepository classeRepository;

    @Autowired
    private FormateurClasseRepository formateurClasseRepository;

    public FormateurClasseController(FormateurClasseService formateurClasseService, FormateurService formateurService, ClasseService classeService) {
        this.formateurClasseService = formateurClasseService;
        this.formateurService = formateurService;
        this.classeService = classeService;
    }

    // Liste de tous les liens formateur-classe
    @GetMapping("/list")
    public String list(Model model) {
        List<FormateurClasse> list = formateurClasseService.getAll();
        model.addAttribute("formateurClasses", list);
        return "formateurClasse/list";  // ta page Thymeleaf
    }

    // Formulaire pour ajouter un lien Formateur-Classe
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("formateurClasse", new FormateurClasse());
        model.addAttribute("formateurs", formateurService.getAllFormateurs());
        model.addAttribute("classes", classeService.getAllClasses());
        return "formateurClasse/form"; // formulaire Thymeleaf
    }

    // Enregistrer la relation FormateurClasse
    @PostMapping("/save")
    public String saveOrUpdate(
        @RequestParam("formateur.formaCode") Integer newFormaCode,
        @RequestParam("classe.classeCode") Integer newClasseCode,
        @RequestParam(value = "oldFormaCode", required = false) Integer oldFormaCode,
        @RequestParam(value = "oldClasseCode", required = false) Integer oldClasseCode
    ) {
        // Récupération de l’objet lié
        Formateur formateur = formateurRepository.findById(newFormaCode)
            .orElseThrow(() -> new RuntimeException("Formateur introuvable"));
        Classe classe = classeRepository.findById(newClasseCode)
            .orElseThrow(() -> new RuntimeException("Classe introuvable"));

        FormateurClasseId newId = new FormateurClasseId(newFormaCode, newClasseCode);

        // Si ancienne clé présente et différente : suppression ancienne ligne
        if (oldFormaCode != null && oldClasseCode != null) {
            FormateurClasseId oldId = new FormateurClasseId(oldFormaCode, oldClasseCode);
            if (!newId.equals(oldId)) {
                formateurClasseRepository.deleteById(oldId);
            }
        }

        FormateurClasse fc = new FormateurClasse();
        fc.setId(newId);
        fc.setFormateur(formateur);
        fc.setClasse(classe);
        formateurClasseRepository.save(fc);

        return "redirect:/formateurClasse/list";
    }



    // Suppression (si besoin)
    @GetMapping("/delete")
    public String delete(@RequestParam Integer formaCode, @RequestParam Integer classeCode) {
        FormateurClasseId id = new FormateurClasseId(formaCode, classeCode);
        formateurClasseService.deleteById(id);
        return "redirect:/formateurClasse/list";
    }
    
   
    
    @GetMapping("/edit/{formaCode}/{classeCode}")
    public String showEditForm(@PathVariable("formaCode") Integer formaCode,
                               @PathVariable("classeCode") Integer classeCode,
                               Model model) {

        // Récupérer l'objet FormateurClasse à partir de sa clé composite
        FormateurClasseId id = new FormateurClasseId(formaCode, classeCode);
        FormateurClasse formateurClasse = formateurClasseService.getById(id);

        // Ajouter l'objet et les listes déroulantes au modèle
        model.addAttribute("formateurClasse", formateurClasse);
        model.addAttribute("formateurs", formateurService.getAllFormateurs());
        model.addAttribute("classes", classeService.getAllClasses());

        return "formateurClasse/form"; // formulaire réutilisé pour la modification
    }


}
