package es.us.lsi.cgis.client;
import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import es.us.lsi.cgis.shared.Contact;

@RemoteServiceRelativePath("contact")
public interface ContactService extends RemoteService {

	List<Contact> getContacts();
	void updateContacts(Integer i, Contact c);
	Contact getContact(Integer i);
/*	void addPatient(Contact c) throws IllegalArgumentException;
	void deletePatient(Integer i);
	*/
	
}
