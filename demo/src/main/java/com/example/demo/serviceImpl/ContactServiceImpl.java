package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ContactNotFoundException;
import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;
import com.example.demo.service.ContactService;



@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
	ContactRepository repo;
	
	@Override
	public String savecontact(Contact contact) {
		repo.save(contact);
		if (contact.getContactId() != null) {
		
		return "contact saved";	
	}
		else {
			return "not saved";
		}
	}

	@Override
	public List<Contact> getAllContacts() {
		
		return repo.findAll();
	}

	@Override
	public Contact getContactById(Integer contactId) {
		
		Contact contact = repo.findById(contactId).orElseThrow(
				()->new ContactNotFoundException("Contact '"+ contactId +"' Not Exists"));

		return contact;
		
//		Optional<Contact>findById=repo.findById(contactId);
//		if(findById.isPresent())
//			return findById.get();
//		return null;
	}

	@Override
	public String updateContact(Contact contact) {
		
		if(repo.existsById(contact.getContactId())) {

			repo.save(contact).getContactId();
			
			return "contact updated";
		}
		else 
		{
		return "Contact not updated";
	}
}

	@Override
	public String deleteContact(Integer contact) {
	
		if(repo.existsById(contact)) {
		
			repo.deleteById(contact);
			
			return"Contact deleted successfully";
		}
		else
		{
			return "Contact not deleted";
		}
	}

	@Override
	public Page<Contact> getAllContact(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmployeeExitsByEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	
}