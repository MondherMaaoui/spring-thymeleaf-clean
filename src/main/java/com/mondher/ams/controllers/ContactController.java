package com.mondher.ams.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/contacts")
public class ContactController {

	static int compteur = 0;
	static List<Contact> contacts = new ArrayList<>();

	@GetMapping("/list")
	public String listContact(Model model) {

		model.addAttribute("contacts", contacts);
		return "contact/listContact";
	}

	@GetMapping("/add")
	public String addGet(Model model) {
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		return "contact/addContact";
	}

	@PostMapping("/add")
	// @ResponseBody
	public String addPost(Contact contact) {

		compteur++;
		contact.setId(compteur);
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateMessage = LocalDateTime.of(date, time);
		
		//DateTimeFormatter format = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		contact.setDateMessage(dateMessage);
		contacts.add(contact);
		return "redirect:list";
		// return contact.toString();
	}

	@GetMapping("/update/{id}")
	public String updateGet(@PathVariable("id") int id, Model model) {
		
		Contact contact = findContactById(id);
		model.addAttribute("contact", contact);
		
		return "contact/updateContact";
	}

	@PostMapping("/update")
	public String updatePost(Contact contact) {
		
		for(Contact c: contacts) {
			if(c.getId() == contact.getId()) {
				c.setTitre(contact.getTitre());
				c.setMessage(contact.getMessage());
				c.setDateMessage(LocalDateTime.now());
			}
		}
		return "redirect:list";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) {
		
		Contact contact = findContactById(id);
		if(!contact.equals(null)) {
			contacts.remove(contact);
		}
		
		model.addAttribute("contacts", contacts);
		return "redirect:../list";
	}

	private Contact findContactById(int id) {
		Contact res = null;
		for (Contact contact : contacts) {
			if (contact.getId() == id) {
             res= contact;
			}
		}
		return res;
	}
}
