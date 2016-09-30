package com.contactlist.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.contactlist.data.Contact;
import com.contactlist.data.ContactNo;
import com.contactlist.data.EmailAddress;

import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
public class ContactsController {

    @RequestMapping(
            value = "/controllers/showcontacts",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Contact>> showContacts() {
    	List<Contact> contacts = getContacts(); 
    	
    	return new ResponseEntity<Collection<Contact>>(contacts,
                HttpStatus.OK);
    }
    
    @RequestMapping(
            value = "/controllers/addcontact",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contact> addContact(@RequestBody Contact newContact) {
    	
    	List<Contact> contacts = getContacts(); 
    	contacts.add(newContact);
    	
    	System.out.println("New contact created : " + newContact.toString());
    	
    	return new ResponseEntity<Contact>(newContact,
    			HttpStatus.CREATED);
    }
    

    private List<Contact> getContacts() {
    	List<Contact> contacts = new ArrayList<Contact>(); 
    	
    	Contact contact1 = new Contact(1l, "Gopal", "Krishnan", "abc@work.com", "abc@personal.com", "044 432558", "9844505255");
    	contacts.add(contact1);
    		
    	Contact contact2 = new Contact(2l, "Sachin", "Tendulkar", "abc@work.com", "abc@personal.com", "044 432558", "9844505255");
    	contacts.add(contact2);

    	Contact contact3 = new Contact(3l, "Saurav", "Ganguli", "abc@work.com", "abc@personal.com", "044 432558", "9844505255");
    	contacts.add(contact3);
    	
    	Contact contact4 = new Contact(4l, "Kapil", "Dev", "abc@work.com", "abc@personal.com", "044 432558", "9844505255");
    	contacts.add(contact4);
    	
    	Contact contact5 = new Contact(5l, "Steve", "Smith","abc@work.com", "abc@personal.com", "044 432558", "9844505255" );
    	contacts.add(contact5);

    	
    	return contacts;
    }
    
    

}
