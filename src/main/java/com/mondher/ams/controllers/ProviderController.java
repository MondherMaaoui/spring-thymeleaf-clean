package com.mondher.ams.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mondher.ams.entities.Formateur;
import com.mondher.ams.entities.Provider;
import com.mondher.ams.services.ProviderService;

@Controller
@RequestMapping("/providers")
public class ProviderController {
	
	@Autowired
	ProviderService providerService;
	@GetMapping("/list")
    public String listProviders(Model model) {
        List<Provider> providers = providerService.listProvider();
        model.addAttribute("providers", providers);
        return "provider/list";  // Crée la vue provider/list.html
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("provider", new Provider());
        return "provider/add";  // Crée la vue provider/add.html
    }

    @PostMapping("/save")
    public String saveProvider(@ModelAttribute Provider provider) {
    	providerService.addProvider(provider);
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String deleteProvider(@PathVariable("id") long id) {
    	providerService.deleteProvider(id);
       
        return "redirect:../list";  // fonctionne  la roote au niveau id on monte d'un cran
    }
    
 // Affichage du formulaire de modification
    @GetMapping("/edit/{id}")
    public String afficherFormulaireModification(@PathVariable("id") long id, Model model) {
        Provider provider = providerService.findProviderById(id);
        if (provider == null) {
            // Gérer l'erreur si le provider n'existe pas
            return "redirect:/provider/list";
        	
        }
        model.addAttribute("provider", provider);
       // return "formateur/add"; // même vue utilisée pour ajouter et modifier
        return "provider/edit";
    }


}
