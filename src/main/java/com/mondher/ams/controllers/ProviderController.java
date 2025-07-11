package com.mondher.ams.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
@Controller
@RequestMapping("/provider")
public class ProviderController {
	
	
	//@GetMapping("/welcome") : ca fonctionne 
	@RequestMapping("/welcome")  // ca fonctionne Get ou Post
	public String welcome() {
		//return "<h1 align=center>Salut Mondher Formateur Java Confirmé</h1>"; // affichage d'un texte avec @RestController au niveau de la classe 
		return "provider/welcome";  // appel a la vue avec @Controller au niveau de la classe
	}
	
	@GetMapping("/welcome1")
    public String welcome(Model model) {
        String nom = "Mondher Maaoui";
        model.addAttribute("nomFormateur", nom);
        return "provider/welcome1"; // welcome1.html
    }
	
	@RequestMapping("/details")
	public String details() {
		//return "<h1 align=center>Salut Formation Java avec le Formateur Mr Mondher Maaoui</h1>";
		return "provider/details";
	}

	@GetMapping("/noms")
    public String afficherNoms(Model model) {
        List<String> noms = List.of("Mondher", "Amine", "Sami", "Khalil", "Imen");
        model.addAttribute("listeNoms", noms);
        return "provider/noms"; // → noms.html
    }
	
	@GetMapping("/listeProviders")
    public String listeProviders(Model model) {
        List<Provider> listeProviders = new ArrayList<>();
        listeProviders.add(new Provider("Samsung","Korea","123456"));
        listeProviders.add(new Provider("HP","USA","654321"));
        listeProviders.add(new Provider("Dell","Chine","789456"));
        model.addAttribute("listeProviders",listeProviders);
        return "provider/listeProviders"; // → listeProviders.html
    }
}
