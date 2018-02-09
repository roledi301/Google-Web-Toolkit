package es.us.lsi.cgis.server;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import es.us.lsi.cgis.client.ContactService;
import es.us.lsi.cgis.server.entities.ContactEntity;
import es.us.lsi.cgis.shared.NUHSAVerifier;
import es.us.lsi.cgis.shared.Contact;

public class ContactServiceImpl extends RemoteServiceServlet implements
		ContactService {

	private static final long serialVersionUID = -6759193213038377169L;
	List<Contact> contacts;

	public void init() {
		
		 contacts = new ArrayList<Contact>(); 
		 contacts.add(new Contact("Sara González García", "sara94gg@hotmail.com", "Ingenieria de la Salud","Solicitar por email"));
		 contacts.add(new Contact("Rocío Leal Díaz", "roledi301@gmail.com","Ingenieria de la Salud","Solicitar por email")); 
		// contacts.add(new Contact("Severo Ochoa","XXXXXXXX", "AN0123456789"));
		 
	}

	@Override
	public List<Contact> getContacts() {
		return contacts;
	}


	public void updateContacts(Integer i, Contact c) {
		contacts.set(i, c);
	}


	public Contact getContact(Integer i) {
		return contacts.get(i);
	}

	
	/*public void addPatient(Contact p) {
		if (!NUHSAVerifier.esNUHSAValido(p.getNUHSA())) {
			IllegalArgumentException exception = new IllegalArgumentException(
					"NUSHA not valid");
			throw exception;
		} else {
			contacts.add(p);
		}
	}

	@Override
	public void deletePatient(Integer i) {
		contacts.remove(i.intValue());
	}*/
	}
