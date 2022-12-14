package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.Contact;

public interface ContactService {
	
	public String savecontact(Contact contact);
	public List<Contact>getAllContacts();
	public Contact getContactById(Integer contactId);
	public String updateContact(Contact contact);
	public String deleteContact(Integer contact);
Page<Contact> getAllContact(Pageable pageable);
	
	boolean isEmployeeExitsByEmail(String email);


}