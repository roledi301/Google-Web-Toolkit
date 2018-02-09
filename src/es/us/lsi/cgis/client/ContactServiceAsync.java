package es.us.lsi.cgis.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import es.us.lsi.cgis.shared.Contact;

public interface ContactServiceAsync {

	void getContacts(AsyncCallback<List<Contact>> callback);

	void updateContacts(Integer i, Contact c, AsyncCallback<Void> callback);

	/*void addPatient(Contact c, AsyncCallback<Void> callback);

	void deletePatient(Integer i, AsyncCallback<Void> callback);*/

	void getContact(Integer i, AsyncCallback<Contact> callback);

}
