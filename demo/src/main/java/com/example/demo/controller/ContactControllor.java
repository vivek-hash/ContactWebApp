package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Contact;
import com.example.demo.service.ContactService;

@RestController
public class ContactControllor {

	@Autowired
	private ContactService service;
	
	@PostMapping("/contact")
	public String savecontact(@RequestBody Contact contact) {
		String Data= service.savecontact(contact);
		return Data;
	}
	@GetMapping("/contacts")
	public List<Contact>getAllContacts(){
		return service.getAllContacts();
	}
	@GetMapping("/contact/{contactId}")
	public Contact getContactById(@PathVariable Integer contactId) {
		return service.getContactById(contactId);
	}
	@PutMapping("/update")
	public String updateContact(@RequestBody Contact contact) {
		return service.updateContact(contact);
	}
	@DeleteMapping("/contact/{contactId}")
	public String deleteContact(@PathVariable Integer contact) {
		return service.deleteContact(contact);
	}
}
