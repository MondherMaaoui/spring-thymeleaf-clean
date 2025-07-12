package com.mondher.ams.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//@RestController
@Controller
@RequestMapping("/provider")
public class ProviderController {
	
	List<Provider> listeProviders = new ArrayList<>();

	
	
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
	
	@RequestMapping("/formulaire")
	public String formulaire() {
		//return "<h1 align=center>Salut Formation Java avec le Formateur Mr Mondher Maaoui</h1>";
		return "provider/formulaire";
	}
	
	@RequestMapping("/email")
    @ResponseBody
	public String getEmail(@RequestParam("email")String email, @RequestParam("nom")String nom) {
		//return "<h1 align=center>Salut Formation Java avec le Formateur Mr Mondher Maaoui</h1>";
		return "votre nom: " + nom + " votre email: " + email;
	}
	
	@RequestMapping("/formulaire1")
	public String formulaire1() {
		//return "<h1 align=center>Salut Formation Java avec le Formateur Mr Mondher Maaoui</h1>";
		return "provider/formulaire1";
	}
	
	@RequestMapping("/email1")
   
	public String getEmail1(Model model,@RequestParam("email")String email, @RequestParam("nom")String nom) {
		model.addAttribute("nom",nom);
		model.addAttribute("email",email);
		return "provider/email";
	}
	
	@RequestMapping("/ajoutProvider")
	public String ajoutProvider() {
		
		return "provider/ajoutProvider";
	}
	
	public void actionAjoutProvider(Provider provider) {
		listeProviders.add(provider);
	}
	
	@RequestMapping("/listeProviders1")
	   
	public String listeProviders1(Model model,
		    @RequestParam(name = "nom", required = false, defaultValue = "") String nom,
		    @RequestParam(name = "adresse", required = false, defaultValue = "") String adresse,
		    @RequestParam(name = "mobile", required = false, defaultValue = "") String mobile) {
		Provider provider = new Provider(nom,adresse,mobile);
		actionAjoutProvider(provider);
		
		model.addAttribute("listeProviders",listeProviders);
		return "provider/listeProviders1";
	}
	
	@RequestMapping("/ajoutProvider2")
	public String ajoutProvider2() {
		
		return "provider/ajoutProvider2";
	}
	
	@RequestMapping("/listeProviders2")
	public String listeProviders2(@ModelAttribute Provider provider, Model model) {
	    actionAjoutProvider(provider); // si besoin
	    model.addAttribute("listeProviders", listeProviders);
	    return "provider/listeProviders2";
	}
	
	@RequestMapping("/ajoutProvider3")
	public String ajoutProvider3(Model model) {
		model.addAttribute("provider", new Provider());
		return "provider/ajoutProvider3";
	}
	
	@RequestMapping("/listeProviders3")
	public String listeProviders3(@ModelAttribute Provider provider, Model model) {
	    actionAjoutProvider(provider); // si besoin
	    model.addAttribute("listeProviders", listeProviders);
	    return "provider/listeProviders3";
	}
	
}
